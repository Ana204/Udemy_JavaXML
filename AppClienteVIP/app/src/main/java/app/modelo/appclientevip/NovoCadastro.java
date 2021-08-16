package app.modelo.appclientevip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NovoCadastro extends AppCompatActivity {

    Button btnvoltar;
    Button cadastrar;
    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    EditText confimarSenha;
    CheckBox checkTermos;

    boolean formularioTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);

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


    }

    //Método para voltar á tela inicial
    private void BtnVoltar() {
        btnvoltar = findViewById(R.id.voltar);

        btnvoltar.setOnClickListener(view -> {

            Intent telaInicial = new Intent(NovoCadastro.this, MainActivity.class);
            startActivity(telaInicial);
        });
    }


    public void validarTermos(View view) {

        if (!checkTermos.isChecked()){

            Toast.makeText(getApplicationContext(), "É necessario aceitar os termos de uso", Toast.LENGTH_LONG).show();
            formularioTrue = true;
        }
    }

    public boolean validarSenhas(){

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

                if (TextUtils.isEmpty(edtNome.getText().toString())){
                    edtNome.setError("Digite seu nome");
                    edtNome.requestFocus();
                    formularioTrue = false;
                }
                else if (TextUtils.isEmpty(edtEmail.getText().toString())){
                    edtEmail.setError("Digite seu email");
                    edtEmail.requestFocus();
                    formularioTrue = false;
                }
                else if (TextUtils.isEmpty(edtSenha.getText().toString())){
                    edtSenha.setError("Digite sua senha");
                    edtSenha.requestFocus();
                    formularioTrue = false;
                }
                else if (TextUtils.isEmpty(confimarSenha.getText().toString())){
                    confimarSenha.setError("Confirme sua senha");
                    confimarSenha.requestFocus();
                    formularioTrue = false;
                }

                if (formularioTrue){

                    if (!validarSenhas()){

                        edtSenha.setError(("Suas senhas não são correspondentes"));
                        confimarSenha.setError(("*"));
                        edtSenha.requestFocus();
                    }
                    else {
                        Toast.makeText(NovoCadastro.this, "Usuario cadastrado com sucesso !!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

}