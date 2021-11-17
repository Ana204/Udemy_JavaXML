package app.daazi.api.v1.permissoes;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Created by marcomaddo on 15/03/2020
 *
 * Curso Desenvolvimento Android do Absoluto Zero para Iniciantes
 * Exemplo de como gerenciar as permissões normais e perigosas
 */
public class SplashActivity extends AppCompatActivity {

    // Use qualquer número
    public static final int APP_PERMISSOES = 2020;

    // Array String com a lista de permissões necessárias
    String[] permissoesRequeridas = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.ACCESS_COARSE_LOCATION,};


    // Time Out para troca de tela
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // Verificar as permissões
        if (validarPermissoes()){
            apresentarTelaSplash();
        }else{
            Toast.makeText(this, "Por favor, verifique as permissões.", Toast.LENGTH_SHORT).show();
        }

    }

    // Carregar a tela principal do aplicativo
    private void apresentarTelaSplash() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                // Carregar normalmente a tela principal

                Intent aplicativo = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(aplicativo);

            }
        }, SPLASH_TIME_OUT);


    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    private  boolean validarPermissoes() {

        int result;

        //Array para verificar se as permissões foram autorizadas
        List<String> permissoesRequeridas = new ArrayList<>();

        //Adiciona as permissões que o app necessita
        for (String permissao: this.permissoesRequeridas){
            result = ContextCompat.checkSelfPermission(SplashActivity.this, permissao);
            if(result != PackageManager.PERMISSION_GRANTED){
                permissoesRequeridas.add(permissao);
            }
        }

        //caso o array não  esteja vazio, significa que tem permissões para serem autorizadas
        if(!permissoesRequeridas.isEmpty()){
            ActivityCompat.requestPermissions(this, permissoesRequeridas.toArray(new String[permissoesRequeridas.size()]), APP_PERMISSOES);
            return false;
        }
        return true;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case APP_PERMISSOES:{
                if (grantResults.length > 0){
                    String permissoesNegadas = "";
                    for (String permissao : permissoesRequeridas){
                        if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                            permissoesNegadas += "\n" + permissao;
                        }
                    }

                    if (permissoesNegadas.length() > 0){
                        Toast.makeText(SplashActivity.this, "Permissões negadas", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SplashActivity.this, "Todas as permissões autorizadas !!", Toast.LENGTH_SHORT).show();
                        apresentarTelaSplash();
                    }

                    return;
                }
                return;
            }
        }
    }
}

