package app.bancodedados.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import app.bancodedados.R;
import app.bancodedados.controller.ClienteController;
import app.bancodedados.controller.ProdutoController;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());

        System.out.println("AQUII MAIN !!");

    }
}