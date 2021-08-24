package app.modelo.appclientevip.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;

public class CredencialAcessoActivity extends AppCompatActivity {

    Button btnvoltar;
    Button cadastrar;
    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    EditText confimarSenha;
    CheckBox checkTermos;

    boolean formularioTrue, isPessoaFisica;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credencial_acesso);

        initFormulario();
        BtnVoltar();
        BtnCadastrar();

    }

    private void initFormulario() {
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        confimarSenha = findViewById(R.id.confimarSenha);
        checkTermos = findViewById(R.id.checkTermos);

        formularioTrue = false;

        restaurarSharedPreferences();
    }

    //Método para voltar á tela inicial
    private void BtnVoltar() {
        btnvoltar = findViewById(R.id.voltar);

        btnvoltar.setOnClickListener(view -> {

            Intent telaInicial = new Intent(CredencialAcessoActivity.this, MainActivity.class);
            startActivity(telaInicial);
        });
    }


    public void validarTermos(View view) {

        if (!checkTermos.isChecked()) {

            Toast.makeText(getApplicationContext(), "É necessario aceitar os termos de uso", Toast.LENGTH_LONG).show();
            formularioTrue = true;
        }
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
                        confimarSenha.setError(("*"));
                        edtSenha.requestFocus();
                    } else {
                        Toast.makeText(CredencialAcessoActivity.this, "Usuario cadastrado com sucesso !!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        isPessoaFisica = preferences.getBoolean("pessoaFisica", true);
        if (isPessoaFisica) {
            edtNome.setText(preferences.getString("nomeCompleto", "Verifique seus dados"));
        } else {
            edtNome.setText(preferences.getString("razaoSocial", "Verifique seus dados"));
        }


    }

}