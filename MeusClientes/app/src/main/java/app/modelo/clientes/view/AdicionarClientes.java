package app.modelo.clientes.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.clientes.R;


public class AdicionarClientes extends Fragment {

    View view;
    TextView txtTitulo;

    public AdicionarClientes() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.adicionar_cliente, container, false);


        iniciarLayout();

        return view;
    }

    /**
     * Inicializar os componentes da tela
     * para adicionar clientes
     */
    private void iniciarLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
//        txtTitulo.setText(R.string.novo_cliente);
    }


}