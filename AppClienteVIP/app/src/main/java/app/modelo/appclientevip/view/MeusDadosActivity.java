package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import app.modelo.appclientevip.R;

public class MeusDadosActivity extends AppCompatActivity {

    EditText edtPrimeiroNome,edtSobrenome,edtCPF,
            edtEmail, edtSenha,edtNomeCompleto, edtcnpj,razaoSocial,edtData;

    CheckBox ckPessoaFisica,ckSimplesNacional,ckMei;

    Button voltarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);

        initMeusDados();
    }

    private void initMeusDados() {

        edtPrimeiroNome = findViewById(R.id.edtPrimeiroNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        edtCPF = findViewById(R.id.edtCPF);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtNomeCompleto = findViewById(R.id.edtNomeCompleto);
        edtcnpj = findViewById(R.id.edtcnpj);
        razaoSocial = findViewById(R.id.razaoSocial);
        edtData = findViewById(R.id.edtData);
        ckPessoaFisica = findViewById(R.id.ckPessoaFisica);
        ckSimplesNacional = findViewById(R.id.ckSimplesNacional);
        ckMei = findViewById(R.id.ckMei);
        voltarBtn = findViewById(R.id.voltarBtn);

    }
}