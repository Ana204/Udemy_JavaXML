package app.modelo.appclientevip.view;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

import java.util.ArrayList;
import java.util.List;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;
import app.modelo.appclientevip.model.Cliente;
import app.modelo.appclientevip.model.ClientePF;
import app.modelo.appclientevip.model.ClientePJ;

public class MainActivity extends AppCompatActivity {

    Cliente cliente;
    ClientePF clientePF;
    ClientePJ clientePJ;
    private SharedPreferences preferences;
    List<Cliente> clientes;

    TextView txtNome;
    Button btnMeusDados, btnAtualizarMeusDados, btnExcluirConta, btnConsultarClientesVIP, btnSairApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTelaInical();

        buscarListaDeClientes();

        sairDoApp();
        meusDados();
        excluirMinhaConta();
        atualizarMeusDados();


    }

    private void buscarListaDeClientes() {

        clientes = new ArrayList<>();


        for (int i = 0; i < 10; i++) {

            cliente = new Cliente();
            cliente.setPrimeiroNome("Cliente nº" +i);

            clientes.add(cliente);
        }
        //-----------------------

         for (Cliente obj: clientes){

            Log.i(AppUtil.LOG_APP, "Clientes: " + obj.getPrimeiroNome() + " - " + obj.getSobrenome());
        }

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

      // restaurarSharedPreferences();

       txtNome.setText("Bem vindo, " + cliente.getPrimeiroNome());
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
        cliente.setPessoaFisica(preferences.getBoolean("senha", true));


        clientePF.setCpf(preferences.getString("cpf", "null"));
        clientePF.setNomeCompleto(preferences.getString("nomeCompleto", "null"));

        clientePJ.setCnpj(preferences.getString("cnpj", "null"));
        clientePJ.setRazaoSocial(preferences.getString("razaoSocial", "null"));
        clientePJ.setSimplesNacional(preferences.getBoolean("simplesNacional", false));
        clientePJ.setMei(preferences.getBoolean("mei", false));
        clientePJ.setDataAbertura(preferences.getString("dataAberturaEmpresa", "null"));

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
                Log.i(AppUtil.LOG_APP, "Nome Completo: " + clientePF.getCpf());

                if(!cliente.isPessoaFisica()){

                    Log.i(AppUtil.LOG_APP, "CNPJ: " + clientePJ.getCnpj());
                    Log.i(AppUtil.LOG_APP, "Razão Social: " + clientePJ.getRazaoSocial());
                    Log.i(AppUtil.LOG_APP, "Data Abertura: " + clientePJ.getDataAbertura());
                    Log.i(AppUtil.LOG_APP, "Simples Nacional: " + clientePJ.isSimplesNacional());
                    Log.i(AppUtil.LOG_APP, "MEI: " + clientePJ.isMei());
                }

            }
        });
    }

    private void atualizarMeusDados() {

        btnAtualizarMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cliente.isPessoaFisica()){

                    cliente.setPrimeiroNome("Raissa");
                    cliente.setSobrenome("Oliveira");

                    clientePF.setNomeCompleto("Raissa Oliveira");

                    //salvarSharedPreferences();

                    Log.i(AppUtil.LOG_APP, "ID: " + cliente.getId());
                    Log.i(AppUtil.LOG_APP, "Primeiro Nome: " + cliente.getPrimeiroNome());
                    Log.i(AppUtil.LOG_APP, "Sobrenome: " + cliente.getSobrenome());
                    Log.i(AppUtil.LOG_APP, "Nome Completo: " + clientePF.getNomeCompleto());
//                    Log.i(AppUtil.LOG_APP, "Email: " + cliente.getEmail());
//                    Log.i(AppUtil.LOG_APP, "Senha: " + cliente.getSenha());


                }
                else {

                    clientePJ.setRazaoSocial("RaOLI");

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
                        .setTitle("EXCLUIR CONTA")
                        .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("TEM CERTEZA QUE DESEJA EXCLUIR SUA CONTA ?")
                        .setNegativeBtnText("RETORNAR")
                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Toast.makeText(MainActivity.this,  "CONTA EXCLUIDA COM SUCESSO !", Toast.LENGTH_SHORT).show();

                            cliente = new Cliente();
                            clientePF = new ClientePF();
                            clientePJ = new ClientePJ();

                           // salvarSharedPreferences();

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


    public void consultarClientes(View view) {

        btnConsultarClientesVIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void sairDoApp() {

        btnSairApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FancyAlertDialog.Builder
                        .with(MainActivity.this)
                        .setTitle("Confirmar saída")
                        .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                        .setMessage("TEM CERTEZA QUE DESEJA SAIR ?")
                        .setNegativeBtnText("RETORNAR")
                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                        .setPositiveBtnText("SIM")
                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                        .onPositiveClicked(dialog -> {
                            Toast.makeText(MainActivity.this,  "VOLTE SEMPRE !", Toast.LENGTH_SHORT).show();
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

}