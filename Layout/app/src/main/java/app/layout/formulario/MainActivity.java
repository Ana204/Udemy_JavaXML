package app.layout.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText primeiroNome;
    EditText segundoNome;
    EditText email;
    EditText telefone;
    EditText senha;
    Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ID relacionado a cada componentes
        primeiroNome = findViewById(R.id.primeiroNome);
        segundoNome = findViewById(R.id.segundoNome);
        email = findViewById(R.id.email);
        telefone = findViewById(R.id.Telefone);
        senha = findViewById(R.id.senha);
        confirmar = findViewById(R.id.confirmar);


        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean camposPreenchidos = true;


                if (TextUtils.isEmpty(primeiroNome.getText().toString()) && TextUtils.isEmpty(segundoNome.getText().toString()) && TextUtils.isEmpty(email.getText().toString()) &&
                TextUtils.isEmpty(senha.getText().toString()) && TextUtils.isEmpty(telefone.getText().toString())){

                     primeiroNome.setError("Digite seu primeiro nome");
                     segundoNome.setError("Digite seu segundo nome");
                     email.setError("Digite seu email");
                     telefone.setError("Digite seu telefone");
                     senha.setError("Digite sua senha");

                     camposPreenchidos = false;

                }
                else {
                    Toast.makeText(getBaseContext(), "PARABÉNS " + primeiroNome.getText(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}