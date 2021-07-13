package app.modelo.clientes.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.clientes.R;


public class AdicionarClientes extends Fragment {

    View view;
    TextView txtTitulo;
    EditText editNome;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;
    CheckBox termos_de_uso;
    Button btnSalvar, btnCancelar;

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
        eventosDeClick();

        return view;
    }



    /**
     * Inicializar os componentes da tela
     * para adicionar clientes
     */
    private void iniciarLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
        editNome = view.findViewById(R.id.editNome);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);
        termos_de_uso = view.findViewById(R.id.termos_de_uso);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

    }


    /**
     *
     */
    private void eventosDeClick() {
        
    }

}