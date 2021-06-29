package app.bancodedados.datamodel;

public class ProdutoDataModel {

    //1 - atributo nome da tabela
    public static final String TABELA = "produto";

    //2 - nomes dos campos
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String CODIGOPRODUTO = "codigoProduto";
    public static final String FORNECEDOR = "fornecedor";

    //3 - Query para criar a tabela no banco
    public static String queryCriarTabela = "";

    //4 - Método para gerar Script para criar a tabela
    public static String criarTabela()
    {
        queryCriarTabela += "CREATE TABLE " +TABELA+ " (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += CODIGOPRODUTO+" text, ";
        queryCriarTabela += FORNECEDOR+" text ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }

}
