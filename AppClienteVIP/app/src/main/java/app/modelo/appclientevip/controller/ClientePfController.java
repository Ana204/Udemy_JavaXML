package app.modelo.appclientevip.controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

import app.modelo.appclientevip.api.AppDataBase;
import app.modelo.appclientevip.dataModel.ClienteDataModel;
import app.modelo.appclientevip.dataModel.ClientePfDataModel;
import app.modelo.appclientevip.model.ClientePF;

public class ClientePfController extends AppDataBase {

    private static final String TABELA = ClientePfDataModel.TABELA;
    private ContentValues dados;

    public ClientePfController(@Nullable  Context context) {
        super(context);
    }

    public boolean incluir(ClientePF obj){

        dados = new ContentValues();

        dados.put(ClientePfDataModel.FK, obj.getClienteID());
        dados.put(ClientePfDataModel.CPF, obj.getCpf());
        dados.put(ClientePfDataModel.NOME_COMPLETO, obj.getNomeCompleto());


        return insert(TABELA, dados);
    }

    public boolean alterar(ClientePF obj){


        dados = new ContentValues();

        dados.put(ClientePfDataModel.ID, obj.getId());
        dados.put(ClientePfDataModel.CPF, obj.getCpf());
        dados.put(ClientePfDataModel.NOME_COMPLETO, obj.getNomeCompleto());

        return update(TABELA, dados);
    }

    public boolean deletar(ClientePF obj){

        dados = new ContentValues();

        //dados.put(ClientePfDataModel.ID, obj.getId());

        return delete(TABELA, obj.getId());
    }

    public List<ClientePF> listar(){

        return listClientesPessoaFisica(TABELA);
    }

    public int getUltimo(){

        return getPk(TABELA);
    }
}
