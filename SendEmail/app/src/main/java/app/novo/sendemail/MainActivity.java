package app.novo.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtPara;
    EditText edtEnviarPara,addAssunto,addMensagem;
    Button btnEnviar;

    Intent intent;
    String emailDestinatario, assunto, mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();

        buttonEnviar();
    }



    private void initForm() {

        txtPara = findViewById(R.id.txtPara);
        edtEnviarPara = findViewById(R.id.edtEnviarPara);
        addAssunto = findViewById(R.id.addAssunto);
        addMensagem = findViewById(R.id.addMensagem);
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    private void buttonEnviar() {

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                ProcessarFormulario();

                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailDestinatario});
                intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Selecione um aplicativo"));

                Toast.makeText(MainActivity.this, "Mensagem enviada com sucesso", Toast.LENGTH_LONG).show();
                edtEnviarPara.setText("");
                addAssunto.setText("");
                addMensagem.setText("");
            }
        });
    }

    private void ProcessarFormulario() {

        emailDestinatario = edtEnviarPara.getText().toString();
        assunto = addAssunto.getText().toString();
        mensagem = addMensagem.getText().toString();
    }
}