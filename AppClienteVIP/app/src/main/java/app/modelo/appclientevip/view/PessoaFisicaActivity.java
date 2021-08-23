package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.modelo.appclientevip.R;

public class PessoaFisicaActivity extends AppCompatActivity {

    Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_fisica);

        initPessoaFisica();

        btnVoltarParaClienteVip();
    }

    private void initPessoaFisica() {

        btn_voltar = findViewById(R.id.btn_voltar);

    }

    private void btnVoltarParaClienteVip() {

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PessoaFisicaActivity.this, ClienteVipActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}