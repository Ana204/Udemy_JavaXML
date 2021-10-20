package app.modelo.appclientevip.dataModel;

public class ClientePjDataModel {

    /**
     *     private String cnpj;
     *     private String razaoSocial;
     *     private String dataAbertura;
     *     private boolean simplesNacional;
     *     private boolean mei;
     */

    public static final String TABELA = "pessoaJuridica";
    public static final String ID = "id";
    public static final String FK = "clientePfID";
    public static final String CNPJ = "cnpj";
    public static final String RAZAOSOCIAL = "razaoSocial";
    public static final String DATA_ABERTURA = "dataAbertura";
    public static final String SIMPLESNACIONAL = "simplesNacional";
    public static final String MEI = "mei";

    private static final String DATA_INCLUSAO = "dataInclusao";
    private static final String DATA_ALTERACAO = "dataAlteracao";

    public static String query;

    public static String TabelaPessoaJuridica() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += FK + " INTEGER, ";
        query += CNPJ + " TEXT, ";
        query += RAZAOSOCIAL + " TEXT, ";
        query += DATA_ABERTURA + " TEXT, ";
        query += SIMPLESNACIONAL + " INTEGER, ";
        query += MEI + " INTEGER, ";
        query += DATA_INCLUSAO + " datetime default current_timestamp, ";
        query += DATA_ALTERACAO + " datetime default current_timestamp, ";
        query += "FOREIGN KEY("+FK+") REFERENCES pessoaFisica(id)";
        query += ")";

        return query;
    }
}
