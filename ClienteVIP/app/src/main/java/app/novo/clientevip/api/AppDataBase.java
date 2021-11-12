package app.novo.clientevip.api;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.novo.clientevip.datamodel.ClienteDataModel;
import app.novo.clientevip.datamodel.ClientePfDataModel;
import app.novo.clientevip.datamodel.ClientePjDataModel;
import app.novo.clientevip.model.Cliente;
import app.novo.clientevip.model.ClientePF;
import app.novo.clientevip.model.ClientePJ;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "cliente.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(ClienteDataModel.TabelaCliente());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE: " + ClienteDataModel.TabelaCliente());
        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA CLIENTE: " + e.getMessage());
        }


        try {
            db.execSQL(ClientePfDataModel.TabelaPessoaFisica());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA FISICA: " + ClientePfDataModel.TabelaPessoaFisica());

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA FISICA: " + e.getMessage());
        }


        try {
            db.execSQL(ClientePjDataModel.TabelaPessoaJuridica());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA JURIDICA: " + ClientePjDataModel.TabelaPessoaJuridica());

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA JURIDICA: " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    /**
     * Inserir dados
     *
     * @return
     */
    public boolean insert(String tabela, ContentValues dados) {

        boolean success = true;

        try {
            success = db.insert(tabela, null, dados) > 0;
            Log.i(AppUtil.LOG_APP, tabela + " - " + "DADOS INSERIDOS COM SUCESSO");
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, tabela + "FALHA EM INSERIR DADOS " + e.getMessage());
        }

        return success;
    }


    /**
     * Atualizar dados
     *
     * @return
     */
    public boolean update(String tabela, ContentValues dados) {

        boolean success = true;

        try {
            int id = dados.getAsInteger("id");
            success = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 1;
            Log.i(AppUtil.LOG_APP, tabela + " - " + "DADOS ATUALIZADO COM SUCESSO");

        } catch (SQLException e) {

            Log.i(AppUtil.LOG_APP, tabela + " - " + "FALHA AO ATUALIZAR DADOS" + e.getMessage());
        }

        return success;
    }


    /**
     * Deletar dados
     *
     * @return
     */
    public boolean delete(String tabela, int id) {

        boolean success = true;

        try {

            success = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;
            Log.i(AppUtil.LOG_APP, tabela + " - " + "DADOS DELETADO COM SUCESSO");
        } catch (SQLException e) {

            Log.e(AppUtil.LOG_APP, tabela + " - " + "FALHA AO DELETAR DADOS" + e.getMessage());
        }

        return success;
    }


    /**
     * Listar dados
     *
     * @return
     */
    public List<Cliente> listClientes(String tabela) {

        List<Cliente> list = new ArrayList<>();
        Cliente cliente;

        String sql = "SELECT * FROM " + tabela;

        try {
            cursor = db.rawQuery(sql, null);

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

                Log.i(AppUtil.LOG_APP, "LISTA GERADA COM SUCESSO !!");
            }
        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "FALHA AO LISTAR" + tabela + " " + e.getMessage());
        }
        return list;
    }


    public List<ClientePF> listClientesPessoaFisica(String tabela) {

        List<ClientePF> list = new ArrayList<>();
        ClientePF clientePF;

        String sql = "SELECT * FROM " + tabela;

        try {

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    clientePF = new ClientePF();

                    clientePF.setId(cursor.getInt(cursor.getColumnIndex(ClientePfDataModel.ID)));
                    clientePF.setClienteID(cursor.getInt(cursor.getColumnIndex(ClientePfDataModel.FK)));
                    clientePF.setCpf(cursor.getString(cursor.getColumnIndex(ClientePfDataModel.CPF)));
                    clientePF.setNomeCompleto(cursor.getString(cursor.getColumnIndex(ClientePfDataModel.NOME_COMPLETO)));

                    list.add(clientePF);
                }
                while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP, "LISTA DE PESSOA FISICA GERADA COM SUCESSO !!");
            }
        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "FALHA AO LISTAR " + " - " + tabela + " " + e.getMessage());
        }
        return list;
    }


    public List<ClientePJ> listClientesPessoaJuridica(String tabela) {

        List<ClientePJ> list = new ArrayList<>();
        ClientePJ clientePJ;

        String sql = "SELECT * FROM " + tabela;

        try {
            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    clientePJ = new ClientePJ();

                    clientePJ.setId(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.ID)));
                    clientePJ.setClientePfID(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.FK)));
                    clientePJ.setCnpj(cursor.getString(cursor.getColumnIndex(ClientePjDataModel.CNPJ)));
                    clientePJ.setRazaoSocial(cursor.getString(cursor.getColumnIndex(ClientePjDataModel.RAZAOSOCIAL)));
                    clientePJ.setDataAbertura(cursor.getString(cursor.getColumnIndex(ClientePjDataModel.DATA_ABERTURA)));
                    clientePJ.setSimplesNacional(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.SIMPLESNACIONAL)) == 1);
                    clientePJ.setMei(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.MEI)) == 1);

                    list.add(clientePJ);
                }
                while (cursor.moveToNext());

                Log.i(AppUtil.LOG_APP, "LISTA DE PESSOA JURIDICA GERADA COM SUCESSO !!");
            }
        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "FALHA AO LISTAR PJ" + tabela + " " + e.getMessage());
        }
        return list;
    }

    public int getLastPk(String tabela) {

        //SELECT seq FROM sqlite_sequence WHERE name="tabela"
        String sql = "SELECT seq FROM sqlite_sequence WHERE name = '" + tabela + "'";

        try {
            Log.i(AppUtil.LOG_APP, "SQL RAW:" + sql);

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()) {

                do {
                    return cursor.getInt(cursor.getColumnIndex("seq"));

                }
                while (cursor.moveToNext());

            }
        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERRO recuperando último PK" + tabela + " " + e.getMessage());
        }
        return -1;
    }

    public Cliente getClienteByID(String tabela, Cliente obj) {

        Cliente cliente = new Cliente();

        String sql = "SELECT * FROM "+tabela+" WHERE id = "+obj.getId();

        try {
            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                cliente.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                cliente.setPrimeiroNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.PRIMEIRO_NOME)));
                cliente.setSobrenome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SOBRENOME)));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                cliente.setSenha(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SENHA)));
                cliente.setPessoaFisica(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.PESSOA_FISICA)) == 1);
            }

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERROR GetClienteByID" + " - " + obj.getId() + " - " + e.getMessage());
        }

        return cliente;
    }

    public ClientePF getClientePFByFK(String tabela, int idFK) {

        ClientePF clientePF = new ClientePF();

        String sql = "SELECT * FROM "+tabela+" WHERE "+ClientePfDataModel.FK+" = "+ idFK;

        try {
            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                clientePF.setId(cursor.getInt(cursor.getColumnIndex(ClientePfDataModel.ID)));
                clientePF.setClienteID(cursor.getInt(cursor.getColumnIndex(ClientePfDataModel.FK)));
                clientePF.setNomeCompleto(cursor.getString(cursor.getColumnIndex(ClientePfDataModel.NOME_COMPLETO)));
                clientePF.setCpf(cursor.getString(cursor.getColumnIndex(ClientePfDataModel.CPF)));
            }

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERROR GetClientePFByFK" + " - " + idFK + " - " + e.getMessage());
        }

        return clientePF;
    }


    public ClientePJ getClientePJByFK(String tabela, int idFK) {

        ClientePJ clientePJ = new ClientePJ();

        String sql = "SELECT * FROM "+tabela+" WHERE "+ClientePjDataModel.FK+" = "+ idFK;

        try {
            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()) {

                clientePJ.setId(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.ID)));
                clientePJ.setClientePfID(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.FK)));
                clientePJ.setCnpj(cursor.getString(cursor.getColumnIndex(ClientePjDataModel.CNPJ)));
                clientePJ.setDataAbertura(cursor.getString(cursor.getColumnIndex(ClientePjDataModel.DATA_ABERTURA)));
                clientePJ.setRazaoSocial(cursor.getString(cursor.getColumnIndex(ClientePjDataModel.RAZAOSOCIAL)));
                clientePJ.setSimplesNacional(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.RAZAOSOCIAL)) == 1);
                clientePJ.setMei(cursor.getInt(cursor.getColumnIndex(ClientePjDataModel.MEI)) == 1);
            }

        } catch (SQLException e) {
            Log.e(AppUtil.LOG_APP, "ERROR GetClientePJByFK" + " - " + idFK + " - " + e.getMessage());
        }

        return clientePJ;
    }

}
