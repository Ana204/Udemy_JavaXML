package app.modelo.appclientevip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import app.modelo.appclientevip.api.AppUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        telaSplash();
    }

    private void telaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, NovoCadastro.class);
                startActivity(intent);
                finish();
                return;

            }
        }, AppUtil.TIME_SPLASH);
    }
}