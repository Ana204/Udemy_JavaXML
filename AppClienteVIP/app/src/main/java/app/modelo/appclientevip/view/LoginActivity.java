package app.modelo.appclientevip.view;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;
import app.modelo.appclientevip.controller.ClienteController;
import app.modelo.appclientevip.model.Cliente;

public class LoginActivity extends AppCompatActivity {

    Cliente cliente;
    private SharedPreferences preferences;

    EditText editEmailLogin, edtSenhaLogin;
    CheckBox checkLembrar;
    TextView recuperarSenha, politicaDePrivacidade;
    Button btnAcessar, btnSejaVip;

    boolean isFormularioLogin, isLembrarSenha;

    ClienteController clienteController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initLogin();

        btnAcessarEvento();
        recuperarsenhaEvento();
        lerPoliticaPrivacidade();

        btnSejaVipEvento();

    }


    private void initLogin() {

        editEmailLogin = findViewById(R.id.editEmailLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);
        recuperarSenha = findViewById(R.id.recuperarSenha);
        politicaDePrivacidade = findViewById(R.id.politicaDePrivacidade);
        btnAcessar = findViewById(R.id.btnAcessar);
        btnSejaVip = findViewById(R.id.btnSejaVip);
        checkLembrar = findViewById(R.id.checkLembrar);

        isFormularioLogin = false;

        cliente = new Cliente();

        clienteController = new ClienteController(getApplicationContext());

        clienteController.incluir(cliente);

        restaurarSharedPreferences();

    }

    private void recuperarsenhaEvento() {

        recuperarSenha.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void lerPoliticaPrivacidade() {

        politicaDePrivacidade.setOnClickListener(v -> FancyAlertDialog.Builder
                .with(LoginActivity.this)
                .setTitle("Confimar Politica de Privacidade & Termos ?")
                .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                .setMessage("TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO TEXTO ?")
                .setNegativeBtnText("NÃO")
                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                .setPositiveBtnText("SIM")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  // for @ColorRes use setNegativeBtnBackgroundRes(R.color.colorvalue)
                .setAnimation(Animation.POP)
                .isCancellable(true)
                .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                .onPositiveClicked(dialog -> Toast.makeText(LoginActivity.this, "SEJA BEM VINDO !", Toast.LENGTH_SHORT).show())
                .onNegativeClicked(dialog -> {
                    Toast.makeText(LoginActivity.this, "É NECESSÁRIO CONFIRMAR A POLÍTICA DE PRIVACIDADE", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                })
                .build()
                .show());


    }

    private boolean validarFormulario() {

        //considerar que o usuario preencheu o formulario
        boolean retorno = true;

        if (TextUtils.isEmpty(editEmailLogin.getText().toString())){
            editEmailLogin.setError("Preencha o campo com seu email");
            editEmailLogin.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(edtSenhaLogin.getText().toString())){
            edtSenhaLogin.setError("Preencha o campo com sua senha");
            edtSenhaLogin.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    private void btnAcessarEvento() {

        btnAcessar.setOnClickListener(view -> {

           if(isFormularioLogin = validarFormulario()){

               if (validarDadosDoUsuario()){

                   salvarSharedPreferences();
                   Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(intent);
                   finish();
                   return;
               }
               else {
                   Toast.makeText(LoginActivity.this, "Verifique seus dados", Toast.LENGTH_LONG).show();
               }
           }
        });
    }

    private boolean validarDadosDoUsuario() {

        return true;
    }

    public void lembrarSenha(View view) {

        isLembrarSenha = checkLembrar.isChecked();

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("loginAutomatico", isLembrarSenha);
        dados.apply();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);

        cliente.setEmail(preferences.getString("email", "teste@teste.com"));
        cliente.setSenha(preferences.getString("senha", "123456"));
        cliente.setPrimeiroNome(preferences.getString("primeiroNome", "Cliente"));
        cliente.setSobrenome(preferences.getString("sobrenome", "Cliente"));
        cliente.setPessoaFisica(preferences.getBoolean("pessoaFisica", true));




    }

    private void btnSejaVipEvento() {

        btnSejaVip.setOnClickListener(view -> {

            Intent intent = new Intent(LoginActivity.this, ClienteVipActivity.class);
            startActivity(intent);
            finish();
            return;
        });
    }


}