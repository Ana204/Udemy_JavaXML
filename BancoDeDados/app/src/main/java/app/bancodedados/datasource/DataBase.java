package app.bancodedados.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.bancodedados.datamodel.ClienteDataModel;
import app.bancodedados.datamodel.ProdutoDataModel;

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
        System.out.println("Cliente criada: " + ClienteDataModel.criarTabela());


        db.execSQL(ProdutoDataModel.criarTabela());
        System.out.println("Produto criada: " + ProdutoDataModel.criarTabela());
;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

    /**
     * Método para incluir dados no banco de dados
     * @return
     */
    public boolean insert(String tabela, ContentValues dados)
    {
        boolean retorno = false;

        return retorno;
    }
}
