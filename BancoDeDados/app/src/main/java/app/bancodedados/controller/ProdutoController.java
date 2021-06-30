package app.bancodedados.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.bancodedados.datamodel.ProdutoDataModel;
import app.bancodedados.datasource.DataBase;
import app.bancodedados.model.Produto;

public class ProdutoController extends DataBase implements ICrud<Produto>{

    ContentValues dadoObjeto;

    public ProdutoController(Context context) {
        super(context);

        System.out.println("Controller Produto");
    }

     @Override
    public boolean incluir(Produto obj) {
        dadoObjeto = new ContentValues();

        dadoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        dadoObjeto.put(ProdutoDataModel.CODIGOPRODUTO, obj.getCodigoProduto());

        return insert(ProdutoDataModel.TABELA, dadoObjeto);
    }

    @Override
    public boolean alterar(Produto obj) {

        dadoObjeto = new ContentValues();

        dadoObjeto.put(ProdutoDataModel.ID, obj.getId());
        dadoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        dadoObjeto.put(ProdutoDataModel.CODIGOPRODUTO, obj.getCodigoProduto());

        return true;
    }

    @Override
    public boolean deletar(int id) {
        return true;
    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        return lista;
    }
}
