package android.studies.minhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.studies.minhaideia.R;
import android.studies.minhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    int microseconds = 5000;

    Cliente client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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