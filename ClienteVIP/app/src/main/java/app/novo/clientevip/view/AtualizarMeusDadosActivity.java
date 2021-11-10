package app.novo.clientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

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

                btnSalvar.setEnabled(true);
                btn_editar.setEnabled(false);

            }
        });
    }

    private void buttonSalvar() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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