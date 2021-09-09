package app.modelo.appclientevip.dataModel;

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

    private static String query;


    public static String Tabela(){

        query = "CREATE TABLE "+TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += PRIMEIRO_NOME+ " TEXT, ";
        query += SOBRENOME+ " TEXT, ";
        query += EMAIL+ " TEXT, ";
        query += SENHA+ " TEXT, ";
        query += PESSOA_FISICA+ " INTEGER, ";
        query += DATA_INCLUSAO+ " TEXT, ";
        query += DATA_ALTERACAO+ " TEXT ";
        query +=")";

        return query;
    }
}
