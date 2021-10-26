package app.novo.clientevip.datamodel;

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

        query = "CREATE TABLE " + TABELA + " (\n ";
        query += ID + "  INTEGER PRIMARY KEY AUTOINCREMENT,\n ";
        query += FK + " INTEGER,\n ";
        query += CNPJ + " TEXT,\n ";
        query += RAZAOSOCIAL + " TEXT,\n ";
        query += DATA_ABERTURA + " TEXT,\n ";
        query += SIMPLESNACIONAL + " INTEGER,\n ";
        query += MEI + " INTEGER,\n ";
        query += DATA_INCLUSAO + " datetime default current_timestamp,\n ";
        query += DATA_ALTERACAO + " datetime default current_timestamp,\n ";
        query += "FOREIGN KEY("+FK+") REFERENCES pessoaFisica(id)";
        query += ")";

        return query;
    }
}
