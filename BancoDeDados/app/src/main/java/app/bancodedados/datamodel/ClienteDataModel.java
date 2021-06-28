package app.bancodedados.datamodel;

public class ClienteDataModel {

    //1 - atributo nome da tabela
    public static final String TABELA = "cliente";

    //2 - Nomes dos campos
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";

    //3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    //4 - Método parar gerar Script para criar a tabela
    public static String criarTabela(){

        //Concatenação de String
        queryCriarTabela += "CREATE TABLE " +TABELA+ " (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += EMAIL+" text , ";
        queryCriarTabela += SENHA+" text ";
        queryCriarTabela += ")";

        return  queryCriarTabela;
    }
}
