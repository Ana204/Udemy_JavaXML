package app.novo.clientevip.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import app.novo.clientevip.api.AppUtil;
import app.novo.clientevip.R;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    boolean isLembrarSenha = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        salvarSharedPreferences();
        restaurarSharedPreferences();

        telaSplash();


    }

    private void telaSplash() {

        new Handler().postDelayed(() -> {

            Intent intent;

            if (isLembrarSenha) {

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

/*        dados.putBoolean("loginAutomatico", false);
        dados.apply();*/
    }

    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.APP_PREFERENCIA, MODE_PRIVATE);

        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);
    }
}