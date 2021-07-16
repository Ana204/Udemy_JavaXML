package app.modelo.clientes.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    EditText pesquisar;
    ListView listView;
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
        clienteController = new ClienteController(getContext());

        listView = (ListView) view.findViewById(R.id.ListView);
        pesquisar = view.findViewById(R.id.Pesquisar);

        //listando dados do banco
        clienteList = clienteController.listar();

        //chamando método para gerar uma lista
        clientes = clienteController.gerarListView();


        clienteAdapter = new ArrayAdapter<>(getContext(), R.layout.lista_item, R.id.itemLista, clientes);
        listView.setAdapter(clienteAdapter);


        //barra de pesquisa
        pesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int start, int count, int after) {

                ListarClientes.this.clienteAdapter.getFilter().filter(filtro);
                System.out.println("FILTRAAAAAAAAAAAAANDO: " + filtro);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }


}