package app.modelo.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NovoCadastro extends AppCompatActivity {

    Button btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);

        btnvoltar = findViewById(R.id.voltar);

        BtnVoltar();

    }

    //Método para voltar á tela inicial
    private void BtnVoltar() {
        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaInicial = new Intent(NovoCadastro.this, MainActivity.class);
                startActivity(telaInicial);
            }
        });
    }
}