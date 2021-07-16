package app.modelo.clientes.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.modelo.clientes.datamodel.ClienteDataModel;
import app.modelo.clientes.datasource.DataBase;
import app.modelo.clientes.model.Cliente;

public class ClienteController extends DataBase implements ICrud<Cliente> {

    ContentValues dadoObjeto;

    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoObjeto = new ContentValues();

        dadoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoObjeto.put(ClienteDataModel.SENHA, obj.getSenha());
        dadoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());


        return insert(ClienteDataModel.TABELA, dadoObjeto);

    }

    @Override
    public boolean deletar(int id) {
        return deleteById(ClienteDataModel.TABELA, id);
    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoObjeto = new ContentValues();

        dadoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoObjeto.put(ClienteDataModel.SENHA, obj.getSenha());

        return update(ClienteDataModel.TABELA, dadoObjeto);
    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);
    }

    public List<String> gerarListView(){

        List<String> clientes = new ArrayList<>();

        for (Cliente obj: listar())
        {
            clientes.add(obj.getId()+ " " + obj.getNome());
        }

        return clientes;
    }
}
