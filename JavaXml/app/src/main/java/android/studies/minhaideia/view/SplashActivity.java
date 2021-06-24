package android.studies.minhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.studies.minhaideia.R;
import android.studies.minhaideia.controller.ClienteController;
import android.studies.minhaideia.core.AppUtil;
import android.studies.minhaideia.model.Cliente;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    int microseconds = 5000;

    Cliente client;
    ClienteController clienteController;
    TextView txtAppVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //pegando o id do textViw para exibir a versão do APP
        txtAppVersion = findViewById(R.id.txtVersionApp);
        txtAppVersion.setText(AppUtil.versaoDoAplicativo());

        clienteController = new ClienteController();

        //method call to switch screens
        changeScreen();
    }

    private void changeScreen() {

        new Handler().postDelayed(() -> {

            client = new Cliente("Ana Gomes", "anagomes@gmail.com", "999999", 20, true);

            //I get the activity I am and I get the activity I want to go
            Intent switchScreens = new Intent(SplashActivity.this, MainActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("nome", client.getNome());
            bundle.putString("email", client.getEmail());

            switchScreens.putExtras(bundle);

            startActivity(switchScreens);
            finish();
        },microseconds);

    }
}