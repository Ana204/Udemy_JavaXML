package professor.marcomaddo.appbancodedadosmeusclientes.controller;

import io.realm.Realm;
import io.realm.RealmResults;
import professor.marcomaddo.appbancodedadosmeusclientes.model.ClienteORM;

public class ClienteORMController {

    public void insert(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(ClienteORM.class).max("id");

        final int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();

    }


    public void update(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        ClienteORM clienteORM = realm.where(ClienteORM.class).equalTo("id", obj.getId())
                .findFirst();


        if (clienteORM != null) {

            realm.beginTransaction();

            clienteORM.setNome(obj.getNome());
            clienteORM.setSalario(obj.getSalario());
            clienteORM.setIdade(obj.getIdade());
            clienteORM.setPreco(obj.getPreco());
            clienteORM.setDataCadastro(obj.getDataCadastro());
            clienteORM.setHoraCadastro(obj.getHoraCadastro());
            clienteORM.setAtivo(obj.isAtivo());

            realm.commitTransaction();
        }
        realm.close();
    }

    public void delete(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<ClienteORM> results = realm.where(ClienteORM.class).equalTo("id", obj.getId()).findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();
    }
}
