package app.modelo.appclientevip.dataModel;

public class ClientePfDataModel {

    /**
     *
     *     private String cpf;
     *     private String nomeCompleto;
     */

    private static final String TABELA = "pessoaFisica";
    private static final String ID = "id";
    private static final String FK = "clienteID";
    private static final String CPF = "cpf";
    private static final String NOME_COMPLETO = "nomeCompleto";
    private static final String DATA_INCLUSAO = "dataInclusao";
    private static final String DATA_ALTERACAO = "dataAlteracao";

    private static String query;

    public static String TabelaPessoaFisica() {

        query = "CREATE TABLE " + TABELA + " ( ";
        query += ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += FK + " INTEGER, ";
        query += CPF + " TEXT, ";
        query += NOME_COMPLETO + " TEXT, ";
        query += DATA_INCLUSAO + " TEXT, ";
        query += DATA_ALTERACAO + " TEXT, ";
        query += "FOREIGN KEY("+FK+") REFERENCES cliente(id)";
        query += ")";

        return query;
    }
}
