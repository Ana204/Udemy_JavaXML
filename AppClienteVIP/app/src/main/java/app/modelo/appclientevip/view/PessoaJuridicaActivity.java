package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;
import app.modelo.appclientevip.model.Cliente;
import app.modelo.appclientevip.model.ClientePJ;

public class PessoaJuridicaActivity extends AppCompatActivity {

    Button voltarBtn, btnSalvarEConcluir, cancelarBtn;
    EditText edtcnpj, razaoSocial, edtData;
    CheckBox ckSimplesNacional, ckMei;

    private SharedPreferences preferences;
    Cliente novoVip;
    ClientePJ clientePessoaJuridica;

    boolean isFormularioPJ, isSimplesNacional, isMei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_juridica);

        initPessoaJuridica();

        btnVoltarParaClienteVip();
        btnSalvarEConcluirEvento();
        btnCancelar();
    }


    private void initPessoaJuridica() {

        edtcnpj = findViewById(R.id.edtcnpj);
        razaoSocial = findViewById(R.id.razaoSocial);
        edtData = findViewById(R.id.edtData);
        voltarBtn = findViewById(R.id.voltarBtn);
        btnSalvarEConcluir = findViewById(R.id.btnSalvarEConcluir);
        cancelarBtn = findViewById(R.id.cancelarBtn);
        ckSimplesNacional = findViewById(R.id.ckSimplesNacional);
        ckMei = findViewById(R.id.ckMei);

        isFormularioPJ = false;
        clientePessoaJuridica = new ClientePJ();
        novoVip = new Cliente();


        restaurarSharedPreferences();

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

    private boolean validarFormulario() {

        //considerar que o usuario  preencheu o formulario
        boolean retorno = true;

        if (TextUtils.isEmpty(edtcnpj.getText().toString())) {
            edtcnpj.setError("Preencha o campo com seu CNPJ");
            retorno = false;
        }
        if (TextUtils.isEmpty(razaoSocial.getText().toString())) {
            razaoSocial.setError("Preencha o campo com sua razão social");
            retorno = false;
        }
        if (TextUtils.isEmpty(edtData.getText().toString())){
            edtData.setError("Preencha o campo com a data");
        }

        return retorno;
    }

    private void btnSalvarEConcluirEvento() {

        btnSalvarEConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioPJ = validarFormulario()) {
                    clientePessoaJuridica.setCnpj(edtcnpj.getText().toString());
                    clientePessoaJuridica.setRazaoSocial(razaoSocial.getText().toString());
                    clientePessoaJuridica.setDataAbertura(edtData.getText().toString());
                    clientePessoaJuridica.setSimplesNacional(isSimplesNacional);
                    clientePessoaJuridica.setMei(isMei);

                    salvarSharedPreferences();

                    Intent intent = new Intent(PessoaJuridicaActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void btnCancelar() {

        cancelarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PessoaJuridicaActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.apply();
    }


    public void simplesNacional(View view) {

        isSimplesNacional = ckSimplesNacional.isChecked();

    }

    public void MEI(View view) {

        isMei = ckMei.isChecked();
    }
}