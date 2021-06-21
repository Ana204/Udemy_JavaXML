package primeiro.nivelamento.nivelamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliente = new Cliente("Ana Lucia", "ana@hotmail.com", "99999999", 20, true);

        System.out.println(cliente);
    }
}