package app.modelo.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;
import app.modelo.appclientevip.controller.ClientePjController;
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

    ClientePjController clientePjController;
    int ultimoIDClientePessoaPf;

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

        clientePjController = new ClientePjController(this);

        restaurarSharedPreferences();

    }

    private void btnVoltarParaClienteVip() {

        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PessoaJuridicaActivity.this, LoginActivity.class);
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
                    //TODO: setar o valor do id do ultimo clientes incluido
                    clientePessoaJuridica.setClientePfID(ultimoIDClientePessoaPf);
                    clientePessoaJuridica.setCnpj(edtcnpj.getText().toString());
                    clientePessoaJuridica.setRazaoSocial(razaoSocial.getText().toString());
                    clientePessoaJuridica.setDataAbertura(edtData.getText().toString());
                    clientePessoaJuridica.setSimplesNacional(isSimplesNacional);
                    clientePessoaJuridica.setMei(isMei);

                    clientePjController.incluir(clientePessoaJuridica);
                    salvarSharedPreferences();

                    Intent intent = new Intent(PessoaJuridicaActivity.this, CredencialAcessoActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    private void btnCancelar() {

        cancelarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FancyAlertDialog.Builder
                        .with(PessoaJuridicaActivity.this)
                        .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("Deseja realmente cancelar ?")
                        .setNegativeBtnText("NÃO")
                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                        .onPositiveClicked(dialog -> Toast.makeText(PessoaJuridicaActivity.this, "Cancelado com sucesso", Toast.LENGTH_SHORT).show())
                        .onNegativeClicked(dialog -> Toast.makeText(PessoaJuridicaActivity.this, "Continue com seu cadastro", Toast.LENGTH_SHORT).show())
                        .build()
                        .show();
            }
        });
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        ultimoIDClientePessoaPf = preferences.getInt("ultimoIDClientePessoaPf", -1);
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("cnpj", edtcnpj.getText().toString());
        dados.putString("razaoSocial", razaoSocial.getText().toString());
        dados.putString("dataAberturaEmpresa", edtData.getText().toString());
        dados.putBoolean("simplesNacional", isSimplesNacional);
        dados.putBoolean("mei", isMei);
        dados.putInt("ultimoIDClientePessoaPf", ultimoIDClientePessoaPf);

        dados.apply();
    }


    public void simplesNacional(View view) {

        isSimplesNacional = ckSimplesNacional.isChecked();

    }

    public void MEI(View view) {

        isMei = ckMei.isChecked();
    }
}