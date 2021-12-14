package app.grafico.appgraficoxy.dataModel;

public class VendasDataModel {

    private final static String TABELA = "vendas";

    private final static String id = "id";
    private final static String quantidade_pedidos = "quantidade_pedidos";
    private final static String pedidos = "pedidos";
    private final static String entregas = "entregas";

    private static String queryCriarTabela = "";

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE " + TABELA;
        queryCriarTabela += "( ";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += quantidade_pedidos + " INTEGER, ";
        queryCriarTabela += pedidos + " INTEGER, ";
        queryCriarTabela += entregas + " INTEGER ";
        queryCriarTabela += ")";

        return  queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getQuantidade_pedidos() {
        return quantidade_pedidos;
    }

    public static String getPedidos() {
        return pedidos;
    }

    public static String getEntregas() {
        return entregas;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        VendasDataModel.queryCriarTabela = queryCriarTabela;
    }
}
