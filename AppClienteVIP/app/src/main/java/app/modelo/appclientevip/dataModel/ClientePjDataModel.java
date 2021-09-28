package app.modelo.appclientevip.dataModel;

public class ClientePjDataModel {

    /**
     *     private String cnpj;
     *     private String razaoSocial;
     *     private String dataAbertura;
     *     private boolean simplesNacional;
     *     private boolean mei;
     */

    private static final String TABELA = "pessoaJuridica";
    private static final String ID = "id";
    private static final String FK = "clientePjID";
    private static final String CNPJ = "cnpj";
    private static final String RAZAOSOCIAL = "razaoSocial";
    private static final String DATA_ABERTURA = "dataAbertura";
    private static final String SIMPLESNACIONAL = "simplesNacional";
    private static final String MEI = "mei";
    private static final String DATA_INCLUSAO = "dataInclusao";
    private static final String DATA_ALTERACAO = "dataAlteracao";

    private static String query;

    public static String TabelaPessoaJuridica() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += FK + " INTEGER, ";
        query += CNPJ + " TEXT, ";
        query += RAZAOSOCIAL + " TEXT, ";
        query += DATA_ABERTURA + " TEXT, ";
        query += SIMPLESNACIONAL + " INTEGER, ";
        query += MEI + " TEXT, ";
        query += DATA_INCLUSAO + " datetime default current_timestamp, ";
        query += DATA_ALTERACAO + " datetime default current_timestamp,, ";
        query += "FOREIGN KEY("+FK+") REFERENCES pessoaFisica(id)";
        query += ")";

        return query;
    }
}
