package app.biblioteca.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FabricaDeObjetos fabricaDeObjetos = FabricaDeObjetos.instance();

        fabricaDeObjetos.modelo("Ana", "ana@teste");

       //Modelo modelo = new Modelo("Anna", "ana@teste.com");
    }
}