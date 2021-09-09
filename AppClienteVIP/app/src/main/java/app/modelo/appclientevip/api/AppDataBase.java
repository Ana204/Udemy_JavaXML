package app.modelo.appclientevip.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.modelo.appclientevip.dataModel.ClienteDataModel;
import app.modelo.appclientevip.dataModel.ClientePfDataModel;
import app.modelo.appclientevip.dataModel.ClientePjDataModel;
import app.modelo.appclientevip.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "cliente.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase database;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(ClienteDataModel.Tabela());
            db.execSQL(ClientePfDataModel.TabelaPessoaFisica());
            db.execSQL(ClientePjDataModel.TabelaPessoaJuridica());

            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE: "+ ClienteDataModel.Tabela());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA FISICA: "+ ClientePfDataModel.TabelaPessoaFisica());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA JURIDICA: "+ ClientePjDataModel.TabelaPessoaJuridica());

        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA: "+ e.getMessage());
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA FISICA: "+ e.getMessage());
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA JURIDICA: "+ e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Inserir dados
     * @return
     */
    public boolean insert(String tabela, ContentValues dados){
        return true;
    }


    /**
     * Atualizar dados
     * @return
     */
    public boolean update(String tabela, ContentValues dados){
        return true;
    }


    /**
     * Deletar dados
     * @return
     */
    public boolean delete(String tabela, ContentValues dados){
        return true;
    }


    /**
     * Listar dados
     * @return
     */
    public List<Cliente> list(){

        List<Cliente> list = new ArrayList<>();
        return list;
    }


}
