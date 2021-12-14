package app.grafico.appgraficoxy.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import app.grafico.appgraficoxy.dataModel.VendasDataModel;
import app.grafico.appgraficoxy.model.Vendas;

public class DataSource extends SQLiteOpenHelper {

    private static final String DB_NAME = "vendas.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(VendasDataModel.criarTabela());

        }catch (Exception e){
            Log.e("VENDAS", "DB ---> ERRO: " + e.getMessage());
            Log.e("QUERY", "DB ---> ERRO: " + VendasDataModel.criarTabela());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String tabela, ContentValues dados){
        boolean sucesso = true;

        try {

            sucesso = db.insert(tabela, null, dados) > 0;

        } catch (Exception e){

            sucesso = false;
        }

        return sucesso;
    }

    public boolean deletar(String tabela, int id){
        boolean sucesso = true;

        sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public boolean alterar(String tabela, ContentValues dados){
        boolean sucesso = true;

        int id = dados.getAsInteger("id");

        sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    public void deletarTabela(String tabela){

        try{
            db.execSQL("DROP TABLE IF EXISTS" + tabela);
        }catch (Exception e){

        }
    }

}
