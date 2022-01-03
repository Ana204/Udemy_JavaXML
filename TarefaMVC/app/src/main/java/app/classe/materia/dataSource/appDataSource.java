package app.classe.materia.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import app.classe.materia.dataModel.criarTabela;

public class appDataSource extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String name = "materia.sqlite";
    private static final int version = 1;

    public appDataSource(Context context) {
        super(context, name, null, version);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try{

            sqLiteDatabase.execSQL(criarTabela.CriarTabela());
            Log.i("TABELA", "TABELA MATERIA CRIADA : " +criarTabela.CriarTabela());

        }catch (SQLException e){
            Log.e("ERROR", "ERROR AO CRIAR TABELA : " +e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean insert(String tabela, ContentValues dados){


        boolean success = true;

        try {

            success = db.insert(tabela, null, dados) > 0;
            Log.i("TABELA ", "DADOS INSERIDOS COM SUCESS0 ");

        }catch (SQLException e){
            Log.e("ERROR", "ERROR AO INSERIR : " +e.getMessage());
        }

        return  success;
    }

}
