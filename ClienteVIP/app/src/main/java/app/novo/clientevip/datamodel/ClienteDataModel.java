package app.novo.clientevip.datamodel;

public class ClienteDataModel {

    /**
     *
     *     private int id;
     *     private String primeiroNome;
     *     private String sobrenome;
     *     private String email;
     *     private String senha;
     *     private boolean pessoaFisica;
     */


    public static final String TABELA = "cliente";

    public static final String ID = "id";
    public static final String PRIMEIRO_NOME = "primeiroNome";
    public static final String SOBRENOME = "sobreNome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    public static final String PESSOA_FISICA = "pessoaFisica";
    private static final String DATA_INCLUSAO = "dataInclusao";
    private static final String DATA_ALTERACAO = "dataAlteracao";

    public static String query;

    /**
     String sqlTabelaCliente = "CREATE TABLE clientes(\n" +
     "id     INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
     "nome   TEXT,\n" +
     "email   TEXT,\n" +
     "status   INTEGER\n" +
     ")";
     */

    public static String TabelaCliente(){

        query = "CREATE TABLE "+TABELA+" (\n ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT,\n ";
        query += PRIMEIRO_NOME+ " TEXT,\n ";
        query += SOBRENOME+ " TEXT,\n ";
        query += EMAIL+ " TEXT,\n ";
        query += SENHA+ " TEXT,\n ";
        query += PESSOA_FISICA+ " INTEGER,\n ";
        query += DATA_INCLUSAO+ " datetime default current_timestamp,\n ";
        query += DATA_ALTERACAO+ " datetime default current_timestamp\n ";
        query += ")";

        // datetime default current_timestamp

        return query;
    }
}
