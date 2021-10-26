package app.novo.clientevip.datamodel;

public class ClientePfDataModel {

    /**
     *     private String cpf;
     *     private String nomeCompleto;
     */

    public static final String TABELA = "pessoaFisica";

    public static final String ID = "id";
    public static final String FK = "clienteID";
    public static final String CPF = "cpf";
    public static final String NOME_COMPLETO = "nomeCompleto";
    private static final String DATA_INCLUSAO = "dataInclusao";
    private static final String DATA_ALTERACAO = "dataAlteracao";

    public static String query;

    public static String TabelaPessoaFisica() {

        query = "CREATE TABLE " + TABELA + " (\n ";
        query += ID + "  INTEGER PRIMARY KEY AUTOINCREMENT,\n ";
        query += FK + " INTEGER,\n ";
        query += CPF + " TEXT,\n ";
        query += NOME_COMPLETO + " TEXT,\n ";
        query += DATA_INCLUSAO + " datetime default current_timestamp,\n ";
        query += DATA_ALTERACAO + " datetime default current_timestamp,\n ";
        query += "FOREIGN KEY("+FK+") REFERENCES cliente(id)";
        query += ")";

        return query;
    }
}
