package app.modelo.clientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import app.modelo.clientes.datamodel.ClienteDataModel;
import app.modelo.clientes.model.Cliente;

public class DataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "Clientes.sqlite";
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    /**
     * Método para incluir dados no banco de dados
     * @return
     */
    public boolean insert(String tabela, ContentValues dados)
    {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;

        }catch (Exception e){

            System.out.println("INSERT: " + e.getMessage());
        }

        return retorno;
    }

    /**
     * Método para deletar usando o ID
     * @param tabela
     * @param id
     * @return
     */
    public boolean deleteById(String tabela, int id)
    {
        db = getWritableDatabase();
        boolean retorno = false;

        try{
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;
        }catch (Exception e)
        {
            System.out.println("DELETE: " +e.getMessage());
        }

        return retorno;
    }


    /**
     * Método para atualizar Cliente
     * @param tabela
     * @param dados
     * @return
     */
    public boolean update(String tabela, ContentValues dados)
    {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.update(tabela, dados, "id = ?" , new String[]{String.valueOf(dados.get("id"))}) > 0;
        }catch (Exception e)
        {
            System.out.println("UPDATE: "+ e.getMessage());
        }

        return retorno;
    }

    public List<Cliente> getAllClientes(String tabela)
    {
        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;

        String sql = "SELECT * FROM " + tabela;
        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){

            do {
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                obj.setSenha(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SENHA)));

                clientes.add(obj);


            }while (cursor.moveToNext());
        }

        return clientes;
    }
}
