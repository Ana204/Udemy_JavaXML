package app.geradorqrcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

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

                //outro
            }
        }
    }

    fun initComponentes() {
        digiteQrCode = findViewById(R.id.digiteQrCode)
        buttonGerar = findViewById(R.id.buttonGerar)
        imgQRCode = findViewById(R.id.imgQRCode)
    }
}