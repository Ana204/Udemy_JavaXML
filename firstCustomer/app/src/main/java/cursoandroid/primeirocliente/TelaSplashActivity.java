package cursoandroid.primeirocliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TelaSplashActivity extends AppCompatActivity {

    int microseconds = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        trocarTela();
    }

    private void trocarTela() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent trocaDetela = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(trocaDetela);
                finish();
            }
        }, microseconds);
    }
}