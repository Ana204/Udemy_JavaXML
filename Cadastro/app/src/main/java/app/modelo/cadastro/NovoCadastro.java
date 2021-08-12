package app.modelo.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class NovoCadastro extends AppCompatActivity {

    Button btnvoltar;
    Button cadastrar;
    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;
    EditText confimarSenha;
    CheckBox checkTermos;

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
        }
    }

    private void BtnCadastrar() {
        cadastrar = findViewById(R.id.cadastrar);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(NovoCadastro.this, "Usuario cadastrado com sucesso !!", Toast.LENGTH_LONG).show();
            }
        });

    }

}