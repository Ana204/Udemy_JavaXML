package app.bancodedados.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.bancodedados.datamodel.ClienteDataModel;

public class DataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppBancodedados.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        System.out.println("Criando banco de Dados !!");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClienteDataModel.criarTabela());

        System.out.println("Tabela Cliente criada: " + ClienteDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
