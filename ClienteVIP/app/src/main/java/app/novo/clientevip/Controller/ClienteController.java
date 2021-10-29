package app.novo.clientevip.Controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import app.novo.clientevip.api.AppDataBase;
import app.novo.clientevip.datamodel.ClienteDataModel;
import app.novo.clientevip.model.Cliente;

public class ClienteController extends AppDataBase {

    private static final String TABELA = ClienteDataModel.TABELA;
    private ContentValues dados;

    public ClienteController(Context context) {
        super(context);
    }


    public boolean incluir(Cliente obj){

        dados = new ContentValues();

        dados.put(ClienteDataModel.PRIMEIRO_NOME, obj.getPrimeiroNome());
        dados.put(ClienteDataModel.SOBRENOME, obj.getSobrenome());
        dados.put(ClienteDataModel.EMAIL, obj.getEmail());
        dados.put(ClienteDataModel.SENHA, obj.getSenha());
        dados.put(ClienteDataModel.PESSOA_FISICA, obj.isPessoaFisica());

        return insert(TABELA, dados);
    }

    public boolean alterar(Cliente obj){

        dados = new ContentValues();

        dados.put(ClienteDataModel.ID, obj.getId());
        dados.put(ClienteDataModel.PRIMEIRO_NOME, obj.getPrimeiroNome());
        dados.put(ClienteDataModel.SOBRENOME, obj.getSobrenome());
        dados.put(ClienteDataModel.EMAIL, obj.getEmail());
        dados.put(ClienteDataModel.SENHA, obj.getSenha());
        dados.put(ClienteDataModel.PESSOA_FISICA, obj.isPessoaFisica());

        return update(TABELA, dados);

    }

    public boolean deletar(Cliente obj){

        dados = new ContentValues();

        //dados.put(ClienteDataModel.ID, obj.getId());

        return delete(TABELA, obj.getId());
    }


   public List<Cliente> listar(){

       return listClientes(TABELA);
    }

    public int getUltimo(){

       return getLastPk(TABELA);
    }


/*    public Cliente getClienteByID(Cliente obj){

        return getClienteByID(ClienteDataModel.TABELA, obj);

    }*/

    public void getClienteByID(Cliente obj){

        getClienteByID(ClienteDataModel.TABELA, obj);

    }
}
