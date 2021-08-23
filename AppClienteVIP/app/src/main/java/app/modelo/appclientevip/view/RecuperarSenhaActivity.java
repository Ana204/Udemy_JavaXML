package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.modelo.appclientevip.R;

public class RecuperarSenhaActivity extends AppCompatActivity {

    Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);


        initRecuperarSenha();

        buttonVoltarParaLogin();
    }


    private void initRecuperarSenha() {

        buttonVoltar = findViewById(R.id.buttonVoltar);

    }

    private void buttonVoltarParaLogin() {

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecuperarSenhaActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

}