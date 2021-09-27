package app.modelo.appclientevip.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    Cursor cursor;

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

        boolean success = true;

        try{
            success = database.insert(tabela, null, dados) > 0;
            Log.i(AppUtil.LOG_APP, tabela+ "Dados inseridos com sucesso");
        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, tabela+ "Falha em inserir dados"+e.getMessage());
        }

        return success;
    }


    /**
     * Atualizar dados
     * @return
     */
    public boolean update(String tabela, ContentValues dados){

        boolean success = true;


        try{
            int id = dados.getAsInteger("id");


            success =  database.update(tabela, dados,"id=?", new String[]{Integer.toString(id)}) > 0;

        }catch (SQLException e){

            Log.i(AppUtil.LOG_APP, tabela+ "Falha ao atualizar dados"+e.getMessage());
        }

        return success;
    }


    /**
     * Deletar dados
     * @return
     */
    public boolean delete(String tabela, int id){

        boolean success = true;

        try{

            success = database.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;
            Log.i(AppUtil.LOG_APP, tabela+ "Dados deletado com sucesso");
        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, tabela+ "Falha ao deletar dados"+e.getMessage());
        }

        return success;
    }


    /**
     * Listar dados
     * @return
     */
    public List<Cliente> list(String tabela){

        List<Cliente> list = new ArrayList<>();
        Cliente cliente;

        String sql = "SELECT * FROM " + tabela;

        cursor = database.rawQuery(sql, null);

        try {

            if (cursor.moveToFirst()) {

                do {
                    cliente = new Cliente();
                    cliente.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                    cliente.setPrimeiroNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.PRIMEIRO_NOME)));
                    cliente.setSobrenome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SOBRENOME)));
                    cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                    cliente.setPessoaFisica(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.PESSOA_FISICA)) == 1);

                    list.add(cliente);
                }
                while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP, "Lista gerada com sucesso !!");
            }
        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "Falha ao listar"+ tabela + " " +e.getMessage());
        }
        return list;
    }


    public int getPk(String tabela){

        //SELECT seq FROM sqlite_sequence WHERE name="tabela"
        String sql = "SELECT seq FROM sqlite_sequence WHERE name = '" + tabela + "'";

        try {
            Log.e(AppUtil.LOG_APP, "SQL RAW:" + sql);

            cursor = database.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                  return cursor.getInt(cursor.getColumnIndex("seq"));

                }
                while (cursor.moveToNext());

            }
        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "ERRO recuperando último PK"+ tabela + " " +e.getMessage());
        }
        return -1;
    }


}
