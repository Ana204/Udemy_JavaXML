package app.novo.clientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import java.util.ArrayList;
import java.util.List;

import app.novo.clientevip.R;
import app.novo.clientevip.api.AppUtil;
import app.novo.clientevip.model.Cliente;
import app.novo.clientevip.model.ClientePF;
import app.novo.clientevip.model.ClientePJ;

public class MainActivity extends AppCompatActivity {

    Cliente cliente;
    ClientePF clientePF;
    ClientePJ clientePJ;
    private SharedPreferences preferences;
    List<Cliente> clientes;
    // ClienteController clienteController;

    TextView txtNome;
    Button btnMeusDados, btnAtualizarMeusDados, btnExcluirConta, btnConsultarClientesVIP, btnSairApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // clienteController = new ClienteController(this);
        //clienteController.getClienteByID(cliente);

        //cliente.getClientePF();


        initTelaInical();

       // buscarListaDeClientes();

        sairDoApp();
        meusDados();
        excluirMinhaConta();
        atualizarMeusDados();
        consultarClientes();

        txtNome.setText("Bem Vindo - " + cliente.getPrimeiroNome());
    }

    private void initTelaInical() {

        txtNome = findViewById(R.id.txtNome);
        btnMeusDados = findViewById(R.id.btnMeusDados);
        btnAtualizarMeusDados = findViewById(R.id.btnAtualizarMeusDados);
        btnExcluirConta = findViewById(R.id.btnExcluirConta);
        btnConsultarClientesVIP = findViewById(R.id.btnConsultarClientesVIP);
        btnSairApp = findViewById(R.id.btnSairApp);

        cliente = new Cliente();
        clientePF = new ClientePF();
        clientePJ = new ClientePJ();


        restaurarSharedPreferences();
    }

    private void buscarListaDeClientes() {

        clientes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            cliente = new Cliente();
            cliente.setPrimeiroNome("Cliente nº " + i);

            clientes.add(cliente);
        }
        //-----------------------
        for (Cliente obj : clientes) {

            Log.i(AppUtil.LOG_APP, "OBJ: " + obj.getPrimeiroNome());
        }

    }

    private void meusDados() {
        btnMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(AppUtil.LOG_APP, "ID: " + cliente.getId());
                Log.i(AppUtil.LOG_APP, "Primeiro Nome: " + cliente.getPrimeiroNome());
                Log.i(AppUtil.LOG_APP, "Sobrenome: " + cliente.getSobrenome());
                Log.i(AppUtil.LOG_APP, "Email: " + cliente.getEmail());
                Log.i(AppUtil.LOG_APP, "Senha: " + cliente.getSenha());

                Log.i(AppUtil.LOG_APP, "CPF: " + clientePF.getCpf());
                Log.i(AppUtil.LOG_APP, "Nome Completo: " + clientePF.getNomeCompleto());

                if (!cliente.isPessoaFisica()) {

                    Log.i(AppUtil.LOG_APP, "CNPJ: " + clientePJ.getCnpj());
                    Log.i(AppUtil.LOG_APP, "Razão Social: " + clientePJ.getRazaoSocial());
                    Log.i(AppUtil.LOG_APP, "Data Abertura: " + clientePJ.getDataAbertura());
                    Log.i(AppUtil.LOG_APP, "Simples Nacional: " + clientePJ.isSimplesNacional());
                    Log.i(AppUtil.LOG_APP, "MEI: " + clientePJ.isMei());
                }

                /*salvarSharedPreferences();
                Intent intent = new Intent(MainActivity.this, MeusDadosActivity.class);
                startActivity(intent);*/
            }
        });
    }

    private void atualizarMeusDados() {

        btnAtualizarMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cliente.isPessoaFisica()) {

                    cliente.setPrimeiroNome("Ana B");
                    cliente.setSobrenome("Gomes");

                    clientePF.setNomeCompleto("Ana B Gomes");

                    //salvarSharedPreferences();

                    Log.i(AppUtil.LOG_APP, "** ALTERAÇÃO DADOS CLIENTE ** ");
                    Log.i(AppUtil.LOG_APP, "Primeiro Nome: " + cliente.getPrimeiroNome());
                    Log.i(AppUtil.LOG_APP, "Sobrenome: " + cliente.getSobrenome());
                    Log.i(AppUtil.LOG_APP, "Nome Completo: " + clientePF.getNomeCompleto());


                } else {
                    clientePJ.setRazaoSocial("GOMES B");

                    Log.i(AppUtil.LOG_APP, "** ALTERAÇÃO DADOS CLIENTE PJ ** ");
                    Log.i(AppUtil.LOG_APP, "Razão Social: " + clientePJ.getRazaoSocial());

                }
            }
        });
    }

    private void excluirMinhaConta() {

        btnExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FancyAlertDialog.Builder
                        .with(MainActivity.this)
                        .setTitle(getResources().getString(R.string.excluirMinhaConta))
                        .setBackgroundColor(Color.parseColor("#FFFFFFFF"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("TEM CERTEZA QUE DESEJA EXCLUIR SUA CONTA ?")
                        .setNegativeBtnText("NÃO")
                        .setNegativeBtnBackground(getResources().getColor(R.color.green))
                        .setPositiveBtnBackground(getResources().getColor(R.color.red))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.mipmap.logo, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Toast.makeText(MainActivity.this, "QUE PENA!! SUA CONTA FOI EXCLUIDA !", Toast.LENGTH_SHORT).show();

                            cliente = new Cliente();
                            clientePF = new ClientePF();
                            clientePJ = new ClientePJ();

                            //salvarSharedPreferences();

                            finish();
                            return;
                        })
                        .onNegativeClicked(dialog -> {
                            Toast.makeText(MainActivity.this, "DIVIRTA-SE", Toast.LENGTH_SHORT).show();
                        })
                        .build()
                        .show();

            }
        });
    }

    private void consultarClientes() {

        btnConsultarClientesVIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsultarClientesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void sairDoApp() {

        btnSairApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FancyAlertDialog.Builder
                        .with(MainActivity.this)
                        .setTitle(getResources().getString(R.string.saida))
                        .setBackgroundColor(Color.parseColor("#FFFFFFFF"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("TEM CERTEZA QUE DESEJA SAIR ?")
                        .setNegativeBtnText("RETORNAR")
                        .setNegativeBtnBackground(getResources().getColor(R.color.green))
                        .setPositiveBtnBackground(getResources().getColor(R.color.red))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.mipmap.logo, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "VOLTE SEMPRE !", Toast.LENGTH_SHORT).show();
                        })
                        .onNegativeClicked(dialog -> {
                            Toast.makeText(MainActivity.this, "DIVIRTA-SE", Toast.LENGTH_SHORT).show();
                        })
                        .build()
                        .show();

            }
        });
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        cliente.setPrimeiroNome(preferences.getString("primeiroNome", "null"));
        cliente.setSobrenome(preferences.getString("sobrenome", "null"));
        cliente.setEmail(preferences.getString("email", "null"));
        cliente.setSenha(preferences.getString("senha", "null"));
        cliente.setPessoaFisica(preferences.getBoolean("pessoaFisica", true));

        clientePF.setCpf(preferences.getString("cpf", "null"));
        clientePF.setNomeCompleto(preferences.getString("nomeCompleto", "null"));

        clientePJ.setCnpj(preferences.getString("cnpj", "null"));
        clientePJ.setRazaoSocial(preferences.getString("razaoSocial", "null"));
        clientePJ.setSimplesNacional(preferences.getBoolean("simplesNacional", false));
        clientePJ.setMei(preferences.getBoolean("mei", false));
        clientePJ.setDataAbertura(preferences.getString("dataAberturaEmpresa", "null"));


    }
}