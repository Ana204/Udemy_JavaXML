package app.novo.clientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import app.novo.clientevip.Controller.ClienteController;
import app.novo.clientevip.Controller.ClientePfController;
import app.novo.clientevip.Controller.ClientePjController;
import app.novo.clientevip.R;
import app.novo.clientevip.api.AppUtil;
import app.novo.clientevip.model.Cliente;

public class AtualizarMeusDadosActivity extends AppCompatActivity {

    EditText edtPrimeiroNome,edtSobrenome,edtCPF,
            edtEmail, edtSenha,edtNomeCompleto, edtcnpj,razaoSocial,edtData;

    CheckBox ckPessoaFisica,ckSimplesNacional,ckMei;

    Button voltarBtn, btnSalvar, btn_editar;

    ClienteController clienteController;
    ClientePfController clientePfController;
    ClientePjController clientePjController;

    Cliente cliente;

    SharedPreferences preferences;
    int clienteID;
    boolean isPessoaFisica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_meus_dados);

        restaurarSharedPreferences();

        initAtualizarDados();
        popularFormulario();
        buttonSalvar();
        buttonEditar();
        buttonVoltar();
    }

    private void initAtualizarDados() {

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
        btnSalvar = findViewById(R.id.btnSalvar);
        btn_editar = findViewById(R.id.btn_editar);

        cliente = new Cliente();
        cliente.setId(clienteID);

        clienteController = new ClienteController(this);
        clientePfController = new ClientePfController(this);
        clientePjController = new ClientePjController(this);
    }

    private void buttonVoltar() {
        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtualizarMeusDadosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void buttonEditar() {
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_editar.setEnabled(false);
                btnSalvar.setEnabled(true);

                if (!isPessoaFisica){
                    edtcnpj.setEnabled(true);
                    razaoSocial.setEnabled(true);
                    edtData.setEnabled(true);
                    ckMei.setEnabled(true);
                    ckSimplesNacional.setEnabled(true);
                    edtPrimeiroNome.setEnabled(true);
                    edtSobrenome.setEnabled(true);
                    edtNomeCompleto.setEnabled(true);
                    edtEmail.setEnabled(true);
                    edtSenha.setEnabled(true);
                    edtCPF.setEnabled(true);
                }
                else {
                    edtPrimeiroNome.setEnabled(true);
                    edtSobrenome.setEnabled(true);
                    edtNomeCompleto.setEnabled(true);
                    edtCPF.setEnabled(true);
                    edtEmail.setEnabled(true);
                    edtSenha.setEnabled(true);
                }



            }
        });
    }

    private void buttonSalvar() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPessoaFisica){
                    //alterar os dados salvando no banco
                    //controller
                    validarFormulario();
                    validarCPF();
                }else {
                    validarFormulario();
                    validarFormularioPJ();
                }

            }
        });
    }

    private boolean validarFormulario() {

        //TODO: verificar se a senha é para validar aqui

        //considerar que o usuario  preencheu o formulario
        boolean retorno = true;

        if (TextUtils.isEmpty(edtPrimeiroNome.getText().toString())) {
            edtPrimeiroNome.setError("Preencha o campo com seu primeiro nome");
            retorno = false;
        }
        if (TextUtils.isEmpty(edtSobrenome.getText().toString())) {
            edtSobrenome.setError("Preencha o campo com seu sobrenome");
            retorno = false;
        }
        if (TextUtils.isEmpty(edtNomeCompleto.getText().toString())) {
            edtNomeCompleto.setError("Preencha o campo com seu nome completo");
            retorno = false;
        }
        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.setError("Preencha o campo com seu primeiro nome");
            retorno = false;
        }

        return retorno;
    }

    private boolean validarCPF(){
        boolean retorno = true;
        String cpf = edtCPF.getText().toString();

        if (TextUtils.isEmpty(cpf)) {
            edtCPF.setError("Preencha o campo com seu CPF");
            retorno = false;
        }
        if (!AppUtil.isCPF(cpf)){
            edtCPF.setError("CPF inválido, tente novamente");
            retorno = false;
        }else {
            edtCPF.setText(AppUtil.mascaraCPF(edtCPF.getText().toString()));
        }
        return retorno;
    }

    private boolean validarFormularioPJ() {

        //considerar que o usuario  preencheu o formulario
        boolean retorno = true;

        String cnpj = edtcnpj.getText().toString();
        if (TextUtils.isEmpty(cnpj)) {
            edtcnpj.setError("Preencha o campo com seu CNPJ");
            retorno = false;
        }
        if (!AppUtil.isCNPJ(cnpj)){
            edtcnpj.setError("*");
            retorno = false;

            Toast.makeText(this, "CNPJ inválido, tente novamente", Toast.LENGTH_LONG).show();
        }else {
            edtcnpj.setText(AppUtil.mascaraCNPJ(edtcnpj.getText().toString()));
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

    private void restaurarSharedPreferences() {
        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        isPessoaFisica = preferences.getBoolean("pessoaFisica", true) ;
        clienteID = preferences.getInt("ultimoId", -1);
    }

    private void popularFormulario() {

        if (clienteID >= 1){

            cliente = clienteController.getClienteByID(cliente);
            cliente.setClientePF(clientePfController.getClientePFByFK(cliente.getId()));

            if (!cliente.isPessoaFisica()){
                cliente.setClientePJ(clientePjController.getClientePJByFK(cliente.getClientePF().getId()));
            }

            //Dados dos obj Cliente
            edtPrimeiroNome.setText(cliente.getPrimeiroNome());
            edtSobrenome.setText(cliente.getSobrenome());
            edtEmail.setText(cliente.getEmail());
            edtSenha.setText(cliente.getSenha());
            ckPessoaFisica.setChecked(cliente.isPessoaFisica());

            //Dados Pessoa Fisica
            edtCPF.setText(cliente.getClientePF().getCpf());
            edtNomeCompleto.setText(cliente.getClientePF().getNomeCompleto());

            //Dados Pessoa Juridica
            if(!cliente.isPessoaFisica()){

                edtcnpj.setText(cliente.getClientePJ().getCnpj());
                edtData.setText(cliente.getClientePJ().getDataAbertura());
                razaoSocial.setText(cliente.getClientePJ().getRazaoSocial());
                ckSimplesNacional.setChecked(cliente.getClientePJ().isSimplesNacional());
                ckMei.setChecked(cliente.getClientePJ().isMei());
            }

        }else {
            FancyAlertDialog.Builder
                    .with(AtualizarMeusDadosActivity.this)
                    .setTitle(getResources().getString(R.string.atencao))
                    .setBackgroundColor(Color.parseColor("#FFFFFFFF"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                    .setMessage("FALHA AO RECUPERAR DADOS !!")
                    .setNegativeBtnText("OK")
                    .setNegativeBtnBackground(getResources().getColor(R.color.green))
                    .setAnimation(Animation.POP)
                    .isCancellable(true)
                    .setIcon(R.mipmap.logo, View.VISIBLE)
                    .onNegativeClicked(dialog -> {
                        Intent intent = new Intent(AtualizarMeusDadosActivity.this, MainActivity.class);
                        startActivity(intent);
                    })
                    .build()
                    .show();
        }
    }
}