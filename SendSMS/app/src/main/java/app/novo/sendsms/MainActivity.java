package app.novo.sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SmsManager smsManager;
    EditText editMessagem, editEnviar;
    Button buttonEnviar;

    String smsEnviar;
    String smsMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();
        buttonEventoEnviar();

    }

    private void initForm() {
        editMessagem = findViewById(R.id.editMessagem);
        editEnviar = findViewById(R.id.editEnviar);
        buttonEnviar = findViewById(R.id.buttonEnviar);
    }


    private void buttonEventoEnviar() {

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                smsEnviar = editEnviar.getText().toString();
                smsMensagem = editMessagem.getText().toString();

                try {
                    smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(smsEnviar, null, smsMensagem, null, null);

                    Toast.makeText(MainActivity.this, "Mensagem enviada !", Toast.LENGTH_LONG).show();

                }catch (Exception e){

                    Toast.makeText(MainActivity.this, "Mensagem não enviada !", Toast.LENGTH_LONG).show();

                    Log.e("SMS" , "ERROR" + e);
                }
            }
        });
    }
}