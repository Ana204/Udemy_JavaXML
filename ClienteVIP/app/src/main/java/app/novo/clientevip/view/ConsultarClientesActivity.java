package app.novo.clientevip.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.novo.clientevip.R;

public class ConsultarClientesActivity extends Activity {

    //List<Cliente> clientes;
    //ClienteAdapter adapter;
    //ClienteController clienteController;

    //Cliente obj;
    RecyclerView rvClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_clientes);

        rvClientes = findViewById(R.id.rvClientes);
        //clienteController = new ClienteController(getApplicationContext());
        //clientes = clienteController.listar();

        //para listar na tela de consultar clientes
/*      for (int i = 0; i < 10; i++){

            obj = new Cliente();

            obj.setPrimeiroNome("Cliente " +i);
            obj.setPessoaFisica(i % 2 == 0);

            clientes.add(obj);
        }*/

      //  adapter = new ClienteAdapter(clientes, getApplicationContext());

        //vClientes.setAdapter(adapter);

        rvClientes.setLayoutManager(new LinearLayoutManager(this));
    }
}
