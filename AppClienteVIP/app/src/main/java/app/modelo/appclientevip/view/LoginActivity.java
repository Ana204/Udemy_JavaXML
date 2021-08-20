package app.modelo.appclientevip.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        cliente = ClienteController.getClienteTeste();

        restaurarSharedPreferences();

    }

    private void recuperarsenhaEvento() {

        recuperarSenha.setOnClickListener(view -> Toast.makeText(LoginActivity.this, "Recuperar Senha !!", Toast.LENGTH_LONG).show());
    }

    private void lerPoliticaPrivacidade() {

        politicaDePrivacidade.setOnClickListener(view -> Toast.makeText(LoginActivity.this, " Ler Política De Privacidade !!", Toast.LENGTH_LONG).show());
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

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
            }


        });
    }

    private boolean validarDadosDoUsuario() {

        return ClienteController.validarDadosDoCliente(cliente, editEmailLogin.getText().toString(), edtSenhaLogin.getText().toString());
    }

    public void lembrarSenha(View view) {

        isLembrarSenha = checkLembrar.isChecked();

    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("loginAutomatico", isLembrarSenha);
        dados.putString("emailCliente", editEmailLogin.getText().toString());
        dados.apply();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);


    }

    private void btnSejaVipEvento() {

        btnSejaVip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, ClienteVipActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }


}