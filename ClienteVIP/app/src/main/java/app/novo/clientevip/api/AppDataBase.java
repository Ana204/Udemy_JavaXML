package app.novo.clientevip.api;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

/*        try {
            db.execSQL(ClienteDataModel.Tabela());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE: "+ ClienteDataModel.Tabela());
        }
        catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA CLIENTE: "+ e.getMessage());
        }


        try {
            db.execSQL(ClientePfDataModel.TabelaPessoaFisica());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA FISICA: "+ ClientePfDataModel.TabelaPessoaFisica());

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA FISICA: "+ e.getMessage());
        }


       try {
            db.execSQL(ClientePjDataModel.TabelaPessoaJuridica());
            Log.i(AppUtil.LOG_APP, "TABELA CLIENTE PESSOA JURIDICA: "+ ClientePjDataModel.TabelaPessoaJuridica());

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "ERROR AO CRIAR TABELA DE PESSOA JURIDICA: "+ e.getMessage());
        }*/


/*        db.execSQL(ClientePjDataModel.TabelaPessoaJuridica());
        System.out.println("Cliente PESSOA JURIDICA criada: ----- " + ClientePjDataModel.TabelaPessoaJuridica());*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


    /**
     * Inserir dados
     * @return
     */
/*    public boolean insert(String tabela, ContentValues dados){

        boolean success = true;

        try{
            success = db.insert(tabela, null, dados) > 0;
            Log.i(AppUtil.LOG_APP, tabela+ "Dados inseridos com sucesso");
        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, tabela+ "Falha em inserir dados"+e.getMessage());
        }

        return success;
    }*/


    /**
     * Atualizar dados
     * @return
     */
/*    public boolean update(String tabela, ContentValues dados){

        boolean success = true;


        try{
            int id = dados.getAsInteger("id");


            success =  db.update(tabela, dados,"id=?", new String[]{Integer.toString(id)}) > 0;

        }catch (SQLException e){

            Log.i(AppUtil.LOG_APP, tabela+ "Falha ao atualizar dados"+e.getMessage());
        }

        return success;
    }*/


    /**
     * Deletar dados
     * @return
     */
/*    public boolean delete(String tabela, int id){

        boolean success = true;

        try{

            success = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;
            Log.i(AppUtil.LOG_APP, tabela+ "Dados deletado com sucesso");
        }
        catch (SQLException e){

            Log.e(AppUtil.LOG_APP, tabela+ "Falha ao deletar dados"+e.getMessage());
        }

        return success;
    }*/


    /**
     * Listar dados
     * @return
     */
/*    public List<Cliente> listClientes(String tabela){

        List<Cliente> list = new ArrayList<>();
        Cliente cliente;

        String sql = "SELECT * FROM " + tabela;

        cursor = db.rawQuery(sql, null);

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
    }*/

/*
    public List<ClientePF> listClientesPessoaFisica(String tabela){

        List<ClientePF> list = new ArrayList<>();
        ClientePF clientePF;

        String sql = "SELECT * FROM " + tabela;

        cursor = db.rawQuery(sql, null);

        try {

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

                Log.i(AppUtil.LOG_APP, "Lista gerada com sucesso !!");
            }
        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "Falha ao listar"+ tabela + " " +e.getMessage());
        }
        return list;
    }
*/

/*    public List<ClientePJ> listClientesPessoaJuridica(String tabela){

        List<ClientePJ> list = new ArrayList<>();
        ClientePJ clientePJ;

        String sql = "SELECT * FROM " + tabela;

        cursor = db.rawQuery(sql, null);

        try {

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

                Log.i(AppUtil.LOG_APP, "Lista gerada com sucesso !!");
            }
        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "Falha ao listar"+ tabela + " " +e.getMessage());
        }
        return list;
    }*/

/*    public int getPk(String tabela){

        //SELECT seq FROM sqlite_sequence WHERE name="tabela"
        String sql = "SELECT seq FROM sqlite_sequence WHERE name = " + tabela;

        try {
            Log.i(AppUtil.LOG_APP, "SQL RAW:" + sql);

            cursor = db.rawQuery(sql, null);

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
    }*/

/*    public Cliente getClienteByID(String tabela, Cliente obj){

        Cliente cliente = new Cliente();

        String sql = "SELECT * FROM" + tabela + "WHERE id = "+obj.getId();

        try{

            cursor = db.rawQuery(sql, null);

            if (cursor.moveToNext()){

                cliente.setPrimeiroNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.PRIMEIRO_NOME)));
                cliente.setSobrenome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SOBRENOME)));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                cliente.setSenha(cursor.getString(cursor.getColumnIndex(ClienteDataModel.SENHA)));
                cliente.setPessoaFisica(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.PESSOA_FISICA)) == 1);
            }

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "ERROR GetClienteByID"+obj.getId() + " - " +e.getMessage());
        }

        return cliente;
    }*/


}
