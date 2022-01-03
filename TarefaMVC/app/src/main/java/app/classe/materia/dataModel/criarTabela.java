package app.classe.materia.dataModel;

public class criarTabela {

    /**
     *     private String CodigoDaMateria;
     *     private String NomeDaMateria;
     */

    public static final String TABELA = "materia";

    public static final String ID = "CodigoDaMateria";
    public static final String Nome = "NomeDaMateria";

    public static String query;

    public static String CriarTabela(){

        query = "CREATE TABLE "+TABELA+" (\n ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT,\n ";
        query += Nome+ " TEXT ";
        query += ")";

        return query;
    }
}
