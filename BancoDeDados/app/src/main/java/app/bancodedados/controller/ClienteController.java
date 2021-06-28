package app.bancodedados.controller;

import android.content.ContentValues;
import android.content.Context;

import app.bancodedados.datamodel.ClienteDataModel;
import app.bancodedados.datasource.DataBase;
import app.bancodedados.model.Cliente;

public class ClienteController extends DataBase implements ICrud<Cliente> {

    ContentValues dadoObjeto;

    public ClienteController(Context context) {
        super(context);

        System.out.println("Banco conectado com sucesso !");
    }

    @Override
    public void incluir(Cliente obj) {

        dadoObjeto = new ContentValues();

        dadoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoObjeto.put(ClienteDataModel.SENHA, obj.getSenha());

    }

    @Override
    public void alterar(Cliente obj) {

        dadoObjeto = new ContentValues();

        dadoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoObjeto.put(ClienteDataModel.SENHA, obj.getSenha());
    }

    @Override
    public void deletar(Cliente obj) {

    }

    @Override
    public void listar(Cliente obj) {

    }
}
