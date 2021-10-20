package app.novo.clientevip;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarSenhaActivity extends AppCompatActivity {

    Button buttonVoltar, btnRecuperar;

    EditText edtEmailCadastrado;

    Boolean isFormularioRecuperarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        initRecuperarSenha();

        buttonVoltarParaLogin();
        buttonRecuperar();
    }


    private void initRecuperarSenha() {

        buttonVoltar = findViewById(R.id.buttonVoltar);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        edtEmailCadastrado = findViewById(R.id.edtEmailCadastrado);

    }

    private void buttonVoltarParaLogin() {

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecuperarSenhaActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    private void buttonRecuperar() {

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isFormularioRecuperarSenha = validarFormulario()) {

                    Toast.makeText(RecuperarSenhaActivity.this, "Senha enviada para o email informado !!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RecuperarSenhaActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validarFormulario() {

        //considerar que o usuario  preencheu o formulario
        boolean retorno = true;

        if (TextUtils.isEmpty(edtEmailCadastrado.getText().toString())) {
            edtEmailCadastrado.setError("Preencha o campo com seu EMAIL cadastrado");
            retorno = false;
        }

        return retorno;
    }

}