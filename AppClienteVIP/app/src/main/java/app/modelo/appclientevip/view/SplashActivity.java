package app.modelo.appclientevip.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.AppUtil;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    boolean LembrarSenha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        telaSplash();

        salvarSharedPreferences();
        restaurarSharedPreferences();


    }

    private void telaSplash() {

        new Handler().postDelayed(() -> {

            Intent intent;

            if (LembrarSenha) {

                intent = new Intent(SplashActivity.this, MainActivity.class);

            } else {
                intent = new Intent(SplashActivity.this, LoginActivity.class);

            }

            startActivity(intent);
            finish();
            return;

        }, AppUtil.TIME_SPLASH);
    }

    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        LembrarSenha = preferences.getBoolean("loginAutomatico", false);


    }
}