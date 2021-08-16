package app.modelo.appclientevip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.modelo.appclientevip.api.AppUtil;

public class MainActivity extends AppCompatActivity {

    TextView data;
    TextView hora;
    Button btnCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.data);
        hora = findViewById(R.id.hora);
        btnCadastro = findViewById(R.id.btnCadastro);


        data.setText(AppUtil.getDataAtual());
        hora.setText(AppUtil.getHoraAtual());

        NovoCadastro();

    }

    //Método do button para acessar a tela de cadastro
    private void NovoCadastro() {

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaCadastro = new Intent(MainActivity.this, NovoCadastro.class);
                startActivity(telaCadastro);

            }
        });
    }
}