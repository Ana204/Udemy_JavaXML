package app.br.com.listadecompras.controller;

import java.util.List;
import app.br.com.listadecompras.model.Produto;
import io.realm.Realm;

public class ProdutoController implements ICrud<Produto>{

    @Override
    public void insert(Produto obj) {

        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(Produto.class).max("id");

        final int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();

    }

    @Override
    public void update(Produto obj) {

        Realm realm = Realm.getDefaultInstance();

        Produto produto = realm.where(Produto.class).equalTo("id", obj.getId()).findFirst();

        if(produto != null){

            realm.beginTransaction();

            produto.setNomeDoProduto(obj.getNomeDoProduto());
            produto.setCodigoDeBarras(obj.getCodigoDeBarras());
            produto.setDataDaInclusao(obj.getDataDaInclusao());
            produto.setUnidadeDeMedida(obj.getUnidadeDeMedida());
            produto.setQuantidade(obj.getQuantidade());
            produto.setPrecoPago(obj.getPrecoPago());
            produto.setImagemProduto(obj.getImagemProduto());

            realm.commitTransaction();
        }
        realm.close();

    }

    @Override
    public void delete(Produto obj) {

    }

    @Override
    public void deleteByID(int id) {

    }

    @Override
    public List<Produto> listar(int id) {
        return null;
    }
}
