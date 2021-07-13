package app.modelo.clientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import app.modelo.clientes.R;
import app.modelo.clientes.controller.ClienteController;
import app.modelo.clientes.model.Cliente;


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
    EditText editSenha;
    CheckBox termos_de_uso;
    Button btnSalvar, btnCancelar;

    Cliente novoCliente;
    ClienteController clienteController;

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
        editSenha = view.findViewById(R.id.editSenha);
        termos_de_uso = view.findViewById(R.id.termos_de_uso);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());

    }


    /**
     *
     */
    private void eventosDeClick() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //considerando que todos os campos estejam preenchidos
                boolean isDadosOk = true;

                //verificando de o campo Nome está vazio, se estiver então isDdadosOk passa a ser falso
                if(TextUtils.isEmpty(editNome.getText())){
                    isDadosOk = false;

                    editNome.setError("Digite o nome completo");
                    editNome.requestFocus();
                }
                else if(TextUtils.isEmpty(editTelefone.getText())){
                    isDadosOk = false;

                    editTelefone.setError("Digite o telefone");
                    editTelefone.requestFocus();
                }
                else if(TextUtils.isEmpty(editEmail.getText())){
                    isDadosOk = false;

                    editEmail.setError("Digite o email");
                    editEmail.requestFocus();
                }
                else if(TextUtils.isEmpty(editCep.getText())){
                    isDadosOk = false;

                    editCep.setError("Digite o cep");
                    editCep.requestFocus();
                }
                else if(TextUtils.isEmpty(editLogradouro.getText())){
                    isDadosOk = false;

                    editLogradouro.setError("Digite o logradouro");
                    editLogradouro.requestFocus();
                }
                else if(TextUtils.isEmpty(editNumero.getText())){
                    isDadosOk = false;

                    editNumero.setError("Digite o Número");
                    editNumero.requestFocus();
                }
                else if(TextUtils.isEmpty(editBairro.getText())){
                    isDadosOk = false;

                    editBairro.setError("Digite o Bairro");
                    editBairro.requestFocus();
                }
                else if(TextUtils.isEmpty(editCidade.getText())){
                    isDadosOk = false;

                    editCidade.setError("Digite a cidade");
                    editCidade.requestFocus();
                }
                else if(TextUtils.isEmpty(editEstado.getText())){
                    isDadosOk = false;

                    editEstado.setError("Digite o estado");
                    editEstado.requestFocus();
                }
                else if(TextUtils.isEmpty(editSenha.getText())){
                    isDadosOk = false;

                    editSenha.setError("Digite a senha");
                    editSenha.requestFocus();
                }

                //Se isDaddos for true então ele grava os dados no banco
                else if(isDadosOk){
                   // clienteController.incluir(novoCliente);
                    System.out.println("DADOS CORRETOS");
                }else {
                    System.out.println("OOPPSSS: PREENCHA TODOS OS CAMPOS");
                }

            }
        });
    }

}