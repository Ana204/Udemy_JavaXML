package app.classe.materia.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import app.classe.materia.dataModel.criarTabela;
import app.classe.materia.dataSource.appDataSource;
import app.classe.materia.model.Materia;

public class MateriaController extends appDataSource {


    public MateriaController(Context context){
        super(context);
    }

    public boolean incluir(Materia obj){

        ContentValues dados;
        boolean sucesso;

        dados = new ContentValues();

        dados.put(criarTabela.Nome, obj.getNomeDaMateria());
        dados.put(criarTabela.ID, obj.getCodigoDaMateria());

        sucesso = insert(criarTabela.TABELA, dados);

        return sucesso;
    }


}
