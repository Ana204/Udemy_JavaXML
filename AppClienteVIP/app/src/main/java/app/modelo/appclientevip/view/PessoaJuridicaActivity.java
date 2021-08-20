package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.modelo.appclientevip.R;

public class PessoaJuridicaActivity extends AppCompatActivity {

    Button voltarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_juridica);

        initPessoaJuridica();

        btnVoltarParaClienteVip();

    }

    private void initPessoaJuridica() {

        voltarBtn = findViewById(R.id.voltarBtn);
    }

    private void btnVoltarParaClienteVip() {

        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PessoaJuridicaActivity.this, ClienteVipActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}