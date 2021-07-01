package app.bancodados.dbtables;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {


    public static final String DB_name = "AppBancodedados.sqlite";
    public static final int DB_version = 1;

    SQLiteDatabase db;

    public DataBase(@Nullable Context context) {
        super(context, DB_name, null, DB_version);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Cliente = "CREATE TABLE clientes \n" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nome TEXT, \n" +
                "email TEXT,\n" +
                "preco NUMERIC, \n" +
                "salario REAL,\n" +
                "idade INTERGER\n" +
                ")";

        try {

            db.execSQL(Cliente);
            System.out.println("TABELA CRIADA COM SUCESSO !!");

        }catch (SQLException e){
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
