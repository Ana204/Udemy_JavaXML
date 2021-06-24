package app.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NOME = "App_sharedPref";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Rodando !!");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        System.out.println("Pasta Criada !!");

    }
}