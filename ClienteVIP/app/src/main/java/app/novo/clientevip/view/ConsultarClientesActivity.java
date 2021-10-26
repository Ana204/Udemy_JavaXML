package app.novo.clientevip.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.novo.clientevip.R;
import app.novo.clientevip.api.ClienteAdapter;
import app.novo.clientevip.model.Cliente;

public class ConsultarClientesActivity extends Activity {

    List<Cliente> clientes;
    ClienteAdapter adapter;
    //ClienteController clienteController;

    Cliente obj;
    RecyclerView rvClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);

        rvClientes = findViewById(R.id.rvClientes);
        //clienteController = new ClienteController(getApplicationContext());
        //clientes = clienteController.listar();

        clientes = new ArrayList<>();
        //para listar na tela de consultar clientes
        for (int i = 0; i < 20; i++) {

            obj = new Cliente();

            obj.setPrimeiroNome("Cliente " + i);
            obj.setPessoaFisica(i % 2 == 0);

            clientes.add(obj);
        }

        adapter = new ClienteAdapter(clientes, getApplicationContext());

        rvClientes.setAdapter(adapter);

        rvClientes.setLayoutManager(new LinearLayoutManager(this));
    }
}
