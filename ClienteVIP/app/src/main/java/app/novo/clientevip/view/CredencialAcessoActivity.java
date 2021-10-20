package app.novo.clientevip.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.novo.clientevip.R;

public class CredencialAcessoActivity extends AppCompatActivity {

    Button btnvoltar;
    Button cadastrar;
    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    EditText confimarSenha;
    CheckBox checkTermos;

    boolean formularioTrue, isPessoaFisica;
/*    private SharedPreferences preferences;
    int clienteID;
    Cliente cliente;
    ClienteController clienteController;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credencial_acesso);

        initFormulario();

        BtnVoltar();
        BtnCadastrar();
        validarTermos();

    }

    private void initFormulario() {
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        confimarSenha = findViewById(R.id.confimarSenha);
        checkTermos = findViewById(R.id.checkTermos);

       /* cliente = new Cliente();
        clienteController = new ClienteController(this);
        restaurarSharedPreferences();*/
    }

    //Método para voltar á tela inicial
    private void BtnVoltar() {
        btnvoltar = findViewById(R.id.voltar);

        btnvoltar.setOnClickListener(view -> {

            Intent telaInicial = new Intent(CredencialAcessoActivity.this, LoginActivity.class);
            startActivity(telaInicial);

        });
    }


    public void validarTermos() {

        checkTermos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkTermos.isChecked()) {

                    Toast.makeText(getApplicationContext(), "É necessario aceitar os termos de uso", Toast.LENGTH_LONG).show();
                    formularioTrue = true;
                }
            }
        });


    }

    public boolean validarSenhas() {

        boolean retorno = false;

        int senha, confirmarSenha;

        senha = Integer.parseInt(edtSenha.getText().toString());
        confirmarSenha = Integer.parseInt(confimarSenha.getText().toString());

        retorno = (senha == confirmarSenha);

        return retorno;

    }

    private void BtnCadastrar() {
        cadastrar = findViewById(R.id.cadastrar);

        formularioTrue = true;

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                    edtEmail.setError("Digite seu email");
                    edtEmail.requestFocus();
                    formularioTrue = false;
                } else if (TextUtils.isEmpty(edtSenha.getText().toString())) {
                    edtSenha.setError("Digite sua senha");
                    edtSenha.requestFocus();
                    formularioTrue = false;
                } else if (TextUtils.isEmpty(confimarSenha.getText().toString())) {
                    confimarSenha.setError("Confirme sua senha");
                    confimarSenha.requestFocus();
                    formularioTrue = false;
                }

                if (formularioTrue) {

                    if (!validarSenhas()) {

                        edtSenha.setError(("Suas senhas não são correspondentes"));
                        confimarSenha.setError(("Suas senhas não são correspondentes"));
                        edtSenha.requestFocus();

                        Toast.makeText(CredencialAcessoActivity.this, "As senhas digitadas não correspodem", Toast.LENGTH_LONG).show();
/*                        FancyAlertDialog.Builder
                                .with(CredencialAcessoActivity.this)
                                .setBackgroundColor(Color.parseColor("#303F9F"))  // for @ColorRes use setBackgroundColorRes(R.color.colorvalue)
                                .setTitle("ATENÇÃO !")
                                .setMessage("As senhas digitadas não correspodem, tente novamente !!")
                                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  // for @ColorRes use setPositiveBtnBackgroundRes(R.color.colorvalue)
                                .setPositiveBtnText("OK")
                                .isCancellable(true)
                                .setIcon(R.drawable.ic_star_border_black_24dp, View.VISIBLE)
                                .onPositiveClicked(dialog -> {})
                                .build()
                                .show();*/
                    }
                    else {

/*                        cliente.setEmail(edtEmail.getText().toString());
                        cliente.setSenha(edtSenha.getText().toString());
                        clienteController.alterar(cliente);

                        salvarSharedPreferences();*/
                        Toast.makeText(CredencialAcessoActivity.this, "Usuario cadastrado com sucesso !!", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(CredencialAcessoActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }

            }
        });

    }

   /* private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        isPessoaFisica = preferences.getBoolean("pessoaFisica", true);
        clienteID = preferences.getInt("clienteID", -1);
        String primeiroNome = preferences.getString("primeiroNome", "null");
        String sobrenome = preferences.getString("sobrenome", "null");

        cliente.setId(clienteID);
        cliente.setPrimeiroNome(primeiroNome);
        cliente.setSobrenome(sobrenome);
        cliente.setPessoaFisica(isPessoaFisica);

        if (isPessoaFisica) {
            edtNome.setText(preferences.getString("nomeCompleto", "Verifique seus dados"));
        } else {
            edtNome.setText(preferences.getString("razaoSocial", "Verifique seus dados"));
        }


    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putString("email", edtEmail.getText().toString());
        dados.putString("senha", edtSenha.getText().toString());
        dados.apply();
    }*/

}