package app.bancodedados.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import app.bancodedados.R;
import app.bancodedados.controller.ClienteController;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());

        System.out.println("Main");

    }
}