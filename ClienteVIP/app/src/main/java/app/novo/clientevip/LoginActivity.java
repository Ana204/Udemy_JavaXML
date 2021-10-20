package app.novo.clientevip;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.novo.clientevip.R;

public class LoginActivity extends AppCompatActivity {

    //Cliente cliente;
    private SharedPreferences preferences;

    EditText editEmailLogin, edtSenhaLogin;
    CheckBox checkLembrar;
    TextView recuperarSenha, politicaDePrivacidade;
    Button btnAcessar, btnSejaVip;

    boolean isFormularioLogin, isLembrarSenha;

    //ClienteController clienteController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initLogin();

/*        btnAcessarEvento();
        recuperarsenhaEvento();
        lerPoliticaPrivacidade();

        btnSejaVipEvento();

        lembrarSenha();*/
    }


    private void initLogin() {

        editEmailLogin = findViewById(R.id.editEmailLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);
        recuperarSenha = findViewById(R.id.recuperarSenha);
        politicaDePrivacidade = findViewById(R.id.politicaDePrivacidade);
        btnAcessar = findViewById(R.id.btnAcessar);
        btnSejaVip = findViewById(R.id.btnSejaVip);
        checkLembrar = findViewById(R.id.checkLembrar);

       // isFormularioLogin = false;
        //clienteController = new ClienteController(getApplicationContext());

        //cliente = new Cliente();

        //Para adicionar 10 dados
/*        for (int i = 0; i < 10; i++) {

            cliente.setPrimeiroNome("Maria_" + i);
            cliente.setSobrenome("Silva_" + i);
            cliente.setEmail("teste@gmail.com_" + i);
            cliente.setSenha("1234_" + i);
            cliente.setPessoaFisica(true);

            clienteController.incluir(cliente);
        }*/

        //Para alterar dado usando id
/*      cliente.setId(1);
        cliente.setPrimeiroNome("Carla");
        cliente.setSobrenome("Gomes");
        cliente.setEmail("Carla@gmail.com");
        cliente.setSenha("1234");
        cliente.setPessoaFisica(false);

        clienteController.alterar(cliente);*/

        //Para deletar dados usando ID
        //cliente.setId(1);

        //clienteController.deletar(cliente);

        // List<Cliente> clientes = clienteController.listar();

       // restaurarSharedPreferences();

    }

/*    private void recuperarsenhaEvento() {

        recuperarSenha.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
            startActivity(intent);
            finish();
        });
    }*/

/*    private void lerPoliticaPrivacidade() {

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


    }*/

/*    private boolean validarFormulario() {

        //considerar que o usuario preencheu o formulario
        boolean retorno = true;

        if (TextUtils.isEmpty(editEmailLogin.getText().toString())) {
            editEmailLogin.setError("Preencha o campo com seu email");
            editEmailLogin.requestFocus();
            retorno = false;
        }
        if (TextUtils.isEmpty(edtSenhaLogin.getText().toString())) {
            edtSenhaLogin.setError("Preencha o campo com sua senha");
            edtSenhaLogin.requestFocus();
            retorno = false;
        }

        return retorno;
    }*/

/*    private void btnAcessarEvento() {

        btnAcessar.setOnClickListener(view -> {

            if (isFormularioLogin = validarFormulario()) {

                if (validarDadosDoUsuario()) {

                    salvarSharedPreferences();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                } else {
                    Toast.makeText(LoginActivity.this, "Verifique seus dados", Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/

/*    private boolean validarDadosDoUsuario() {

        return true;
    }

    public void lembrarSenha() {

        checkLembrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLembrarSenha = checkLembrar.isChecked();
            }
        });
    }*/

/*    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("loginAutomatico", isLembrarSenha);
        dados.apply();
    }*/

/*    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);

        cliente.setEmail(preferences.getString("email", "null"));
        cliente.setSenha(preferences.getString("senha", "null"));
        cliente.setPrimeiroNome(preferences.getString("primeiroNome", "null"));
        cliente.setSobrenome(preferences.getString("sobrenome", "null"));
        cliente.setPessoaFisica(preferences.getBoolean("pessoaFisica", true));


    }*/

/*    private void btnSejaVipEvento() {

        btnSejaVip.setOnClickListener(view -> {

            Intent intent = new Intent(LoginActivity.this, ClienteVipActivity.class);
            startActivity(intent);
            finish();
            return;
        });
    }*/


}