package app.bancodedados.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import app.bancodedados.R;
import app.bancodedados.controller.ClienteController;
import app.bancodedados.controller.ProdutoController;
import app.bancodedados.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
   // ProdutoController produtoController;

    Cliente obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obj = new Cliente();
        obj.setNome("Ferreira");
        obj.setEmail("Ferreira.com");
        obj.setSenha("123456");

        clienteController = new ClienteController(getApplicationContext());

        if ( clienteController.incluir(obj))
        {
            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome()+ " incluído com sucesso", Toast.LENGTH_SHORT).show();

            System.out.println("Cliente " +obj.getNome() + "incluido com sucesso");
        }
        else {
            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome()+ " Falha ao incluir", Toast.LENGTH_SHORT).show();

            System.out.println("Cliente " +obj.getNome() + "Falha ao incluir");
        }

    }
}