package app.bancodedados.controller;

import java.util.ArrayList;
import java.util.List;

import app.bancodedados.model.Produto;

public class ProdutoController  implements ICrud<Produto>  {
    @Override
    public boolean incluir(Produto obj) {

        return true;
    }

    @Override
    public boolean alterar(Produto obj) {
        return true;
    }

    @Override
    public boolean deletar(Produto obj) {
        return true;
    }

    @Override
    public List<Produto> listar() {

        List<Produto> listar = new ArrayList<>();

        return listar;
    }
}
