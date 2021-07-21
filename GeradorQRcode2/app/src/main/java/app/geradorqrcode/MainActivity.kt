package app.geradorqrcode

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class MainActivity : AppCompatActivity() {

    var digiteQrCode: EditText? = null
    var buttonGerar: Button? = null
    var imgQRCode: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponentes()

        buttonGerar!!.setOnClickListener {
            if (TextUtils.isEmpty(digiteQrCode!!.text.toString())){

                digiteQrCode!!.error = "*"
                digiteQrCode!!.requestFocus()
            }else{

               gerarQRcode(digiteQrCode!!.text.toString())
            }
        }
    }


    fun initComponentes() {
        digiteQrCode = findViewById(R.id.digiteQrCode)
        buttonGerar = findViewById(R.id.buttonGerar)
        imgQRCode = findViewById(R.id.imgQRCode)
    }

    fun gerarQRcode(conteudoQRCode: String) {

        val qrCode = QRCodeWriter()

        try {

            val bitMatrix = qrCode.encode(conteudoQRCode, BarcodeFormat.QR_CODE, 200, 233)

            var width = bitMatrix.width
            val height = bitMatrix.height

            val  bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

            for (x in 0 until width){
                for (y in 0 until height){
                    bitmap.setPixel(x,y, if (bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                }
            }

            imgQRCode!!.setImageBitmap(bitmap)

        }catch (e: WriterException){

        }
    }
}