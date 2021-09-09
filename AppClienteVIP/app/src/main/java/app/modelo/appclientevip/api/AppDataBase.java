package app.modelo.appclientevip.api;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import app.modelo.appclientevip.dataModel.ClienteDataModel;
import app.modelo.appclientevip.dataModel.ClientePfDataModel;

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

            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE: "+ ClienteDataModel.Tabela());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA FISICA: "+ ClientePfDataModel.TabelaPessoaFisica());

        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA: "+ e.getMessage());
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA FISICA: "+ e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
