package app.modelo.appclientevip.view;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.modelo.appclientevip.R;
import app.modelo.appclientevip.api.ClienteAdapter;
import app.modelo.appclientevip.model.Cliente;

public class ConsultarClientesActivity extends Activity {

    List<Cliente> clientes;
    ClienteAdapter adapter;

    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);

        clientes = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            obj = new Cliente();

            obj.setPrimeiroNome("Cliente " +i);
            obj.setPessoaFisica(i % 2 == 0);

            clientes.add(obj);
        }

        adapter = new ClienteAdapter(clientes, getApplicationContext());
    }
}
