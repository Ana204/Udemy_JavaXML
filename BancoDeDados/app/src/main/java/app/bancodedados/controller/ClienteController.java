package app.bancodedados.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.bancodedados.datamodel.ClienteDataModel;
import app.bancodedados.datasource.DataBase;
import app.bancodedados.model.Cliente;

public class ClienteController extends DataBase implements ICrud<Cliente> {

    ContentValues dadoObjeto;

    public ClienteController(Context context) {
        super(context);

        System.out.println("Controller Cliente !");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoObjeto = new ContentValues();

        dadoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoObjeto.put(ClienteDataModel.SENHA, obj.getSenha());

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

        List<Cliente> lista = new ArrayList<>();

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Ana Gomes");
        cliente.setEmail("anaGomes.@hotm.com");
        cliente.setSenha("0000000");

        lista.add(cliente);

        return lista;
    }
}
