package app.modelo.appclientevip.controller;

import android.content.ContentValues;
import android.content.Context;
import androidx.annotation.Nullable;

import java.util.List;

import app.modelo.appclientevip.api.AppDataBase;
import app.modelo.appclientevip.dataModel.ClienteDataModel;
import app.modelo.appclientevip.model.Cliente;

public class ClienteController extends AppDataBase {

    private static final String TABELA = ClienteDataModel.TABELA;
    private ContentValues dados;

    public ClienteController(@Nullable  Context context) {
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

        dados.put(ClienteDataModel.ID, obj.getId());

        return delete(TABELA, obj.getId());
    }

    public List<Cliente> listar(){

        return listClientes(TABELA);
    }

    public int getUltimo(){

        return getPk(TABELA);
    }
}
