package app.geradorqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class MainActivity extends AppCompatActivity {

    EditText digiteQrCode;
    Button buttonGerar;
    ImageView imgQRCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponentes();

        buttonGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(digiteQrCode.getText().toString())){
                    digiteQrCode.setError("*");
                    digiteQrCode.requestFocus();
                }else {
                    gerarQRcode(digiteQrCode.getText().toString());
                }
            }
        });
    }

    private void initComponentes() {

        digiteQrCode = findViewById(R.id.digiteQrCode);
        buttonGerar = findViewById(R.id.buttonGerar);
        imgQRCode = findViewById(R.id.imgQRCode);
    }


    private void gerarQRcode(String conteudoDoQRCode) {

        QRCodeWriter qrCode = new QRCodeWriter();

        try {

            BitMatrix bitMatrix = qrCode.encode(conteudoDoQRCode, BarcodeFormat.QR_CODE, 200, 233);

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

            for (int x = 0; x < width; x++){

                for (int y = 0; y <height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }

            imgQRCode.setImageBitmap(bitmap);

        }catch (WriterException e){

            e.printStackTrace();
        }
    }


}