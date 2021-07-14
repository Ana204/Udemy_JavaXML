package app.modelo.clientes.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.clientes.R;
import app.modelo.clientes.controller.ClienteController;
import app.modelo.clientes.model.Cliente;


public class ListarClientes extends Fragment {

    View view;
    EditText Pesquisar;
    ListView ListView;
    List<Cliente> clienteList;
    List<String> clientes;
    ArrayAdapter<String> clienteAdapter;
    ArrayList<HashMap<String, String>> filtroClientes;

    ClienteController clienteController;
    Cliente cliente;

    public ListarClientes() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.listar_clientes, container, false);

        TextView listarClientes = view.findViewById(R.id.nav_listar_clientes);

        clienteController = new ClienteController(getContext());

        clienteList = clienteController.listar();

        clientes = new ArrayList<>();

        for (Cliente obj: clienteList)
        {
            clientes.add(obj.getNome()+ " " + obj.getId());
        }
        return view;
    }


}