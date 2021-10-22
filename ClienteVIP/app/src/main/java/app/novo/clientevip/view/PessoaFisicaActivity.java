package app.novo.clientevip.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import app.novo.clientevip.R;
import app.novo.clientevip.api.AppUtil;
import app.novo.clientevip.model.Cliente;
import app.novo.clientevip.model.ClientePF;


public class PessoaFisicaActivity extends AppCompatActivity {

    Button btn_voltar, btnSalvarEContinuar, cancelarBtn;
    EditText edtCPF, edtNomeCompleto;
    //ClientePfController clientePfController;


    Cliente novoVip;
    ClientePF clientePessoaFisica;
    private SharedPreferences preferences;

    boolean isFormularioPF, isPessoaFisica;
    int clienteID;
    int ultimoIDClientePessoaPf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_fisica);

        initPessoaFisica();

        btnVoltarParaClienteVip();
        btnSalvarEcontinuar();
        btnCancelar();
    }

    private void initPessoaFisica() {

        edtCPF = findViewById(R.id.edtCPF);
        edtNomeCompleto = findViewById(R.id.edtNomeCompleto);
        btn_voltar = findViewById(R.id.btn_voltar);
        btnSalvarEContinuar = findViewById(R.id.btnSalvarEContinuar);
        cancelarBtn = findViewById(R.id.cancelarBtn);

        isFormularioPF = false;
        clientePessoaFisica = new ClientePF();
        novoVip = new Cliente();
        //clientePfController = new ClientePfController(this);

        restaurarSharedPreferences();
    }

    private boolean validarFormulario() {

        //considerar que o usuario  preencheu o formulario
        boolean retorno = true;
        String cpf = edtCPF.getText().toString();

        if (TextUtils.isEmpty(cpf)) {
            edtCPF.setError("Preencha o campo com seu CPF");
            retorno = false;
        }
        if (!AppUtil.isCPF(cpf)){
            edtCPF.setError("Preencha o campo com seu CPF");
            retorno = false;

            Toast.makeText(this, "CPF inválido, tente novamente !!", Toast.LENGTH_LONG).show();
        }else {
            edtCPF.setText(AppUtil.mascaraCPF(edtCPF.getText().toString()));
        }

        if (TextUtils.isEmpty(edtNomeCompleto.getText().toString())) {
            edtNomeCompleto.setError("Preencha o campo com seu nome completo");
            retorno = false;
        }

        return retorno;
    }

    private void btnVoltarParaClienteVip() {

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PessoaFisicaActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    private void btnSalvarEcontinuar() {

        btnSalvarEContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioPF = validarFormulario()) {

                    clientePessoaFisica.setCpf(edtCPF.getText().toString());
                    clientePessoaFisica.setNomeCompleto(edtNomeCompleto.getText().toString());
                    //clientePessoaFisica.setClienteID(clienteID);

                    //clientePfController.incluir(clientePessoaFisica);
                    //ultimoIDClientePessoaPf = clientePfController.getUltimo();

                    salvarSharedPreferences();

                    if (isPessoaFisica){

                        Intent intent = new Intent(PessoaFisicaActivity.this, CredencialAcessoActivity.class);
                        startActivity(intent);
                        finish();

                    }else {

                        Intent intent = new Intent(PessoaFisicaActivity.this, PessoaJuridicaActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    private void btnCancelar() {
        cancelarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FancyAlertDialog.Builder
                        .with(PessoaFisicaActivity.this)
                        .setBackgroundColor(Color.parseColor("#FFFFFFFF"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("Deseja realmente cancelar ?")
                        .setNegativeBtnText("NÃO")
                        .setNegativeBtnBackground(getResources().getColor(R.color.red))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnBackground(getResources().getColor(R.color.green))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.mipmap.logo, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Toast.makeText(PessoaFisicaActivity.this, "Cancelado com sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .onNegativeClicked(dialog -> Toast.makeText(PessoaFisicaActivity.this, "Continue com seu cadastro", Toast.LENGTH_SHORT).show())
                        .build()
                        .show();
                ;
            }
        });
    }

    private void salvarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("cpf", edtCPF.getText().toString());
        dados.putString("nomeCompleto", edtNomeCompleto.getText().toString());
       // dados.putInt("ultimoIDClientePessoaPf", ultimoIDClientePessoaPf);
        dados.apply();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        isPessoaFisica = preferences.getBoolean("pessoaFisica", true);
       // clienteID = preferences.getInt("UltimoID", -1);
    }




}