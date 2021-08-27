package app.modelo.appclientevip.view;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;

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

    TextView txtNome;
    Button btnMeusDados, btnAtualizarMeusDados, btnExcluirConta, btnConsultarClientesVIP, btnSairApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTelaInical();

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


    public void meusDados(View view) {

        btnMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void atualizarMeusDados(View view) {

        btnAtualizarMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void excluirMinhaConta(View view) {

        btnExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    public void sairDoApp(View view) {

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
                            Toast.makeText(MainActivity.this, cliente.getPrimeiroNome() + "VOLTE SEMPREs !", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                            })
                        .onNegativeClicked(dialog -> {
                            Toast.makeText(MainActivity.this, "DIVIRTA-SE", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        })
                        .build()
                        .show();

            }
        });
    }
}