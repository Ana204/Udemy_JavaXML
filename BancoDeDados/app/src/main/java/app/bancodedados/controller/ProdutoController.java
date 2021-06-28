package app.bancodedados.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.bancodedados.datamodel.ProdutoDataModel;
import app.bancodedados.datasource.DataBase;
import app.bancodedados.model.Produto;

public class ProdutoController extends DataBase implements ICrud<Produto>  {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {
        super(context);

        System.out.println("Controller Produto !!");
    }

    @Override
    public boolean incluir(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.CODIGOPRODUTO, obj.getCodigoProduto());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return false;
    }

    @Override
    public boolean alterar(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID, obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.CODIGOPRODUTO, obj.getCodigoProduto());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return false;
    }

    @Override
    public boolean deletar(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID, obj.getId());
        return false;
    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        return lista;
    }
}
