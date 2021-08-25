package app.modelo.appclientevip.view;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import app.modelo.appclientevip.R;

public class MainActivity extends AppCompatActivity {

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

    }


}