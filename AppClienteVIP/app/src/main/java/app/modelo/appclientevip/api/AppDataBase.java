package app.modelo.appclientevip.api;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import app.modelo.appclientevip.dataModel.ClienteDataModel;

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

            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE: "+ ClienteDataModel.Tabela());

        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA: "+ e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
