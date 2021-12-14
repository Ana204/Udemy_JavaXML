package app.grafico.appgraficoxy.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import app.grafico.appgraficoxy.dataModel.VendasDataModel;
import app.grafico.appgraficoxy.dataSource.DataSource;

public class VendasController extends DataSource {

    ContentValues dados;

    public VendasController(Context context) {
        super(context);
    }


    public void salvarDados(Number[] dadosQuantidadesPedidos, Number[] dadosPedidos, Number[] dadosEntregas) {

        int registros = dadosQuantidadesPedidos.length;

        for (int i = 0; i < registros; i++) {

            dados = new ContentValues();

            Number quantidade = dadosQuantidadesPedidos[i];
            Number pedidos = dadosPedidos[i];
            Number entregas = dadosEntregas[i];

            dados.put(VendasDataModel.getQuantidade_pedidos(), String.valueOf(quantidade));
            dados.put(VendasDataModel.getPedidos(), String.valueOf(pedidos));
            dados.put(VendasDataModel.getEntregas(), String.valueOf(entregas));

            insert(VendasDataModel.getTABELA(), dados);

            Log.v("DADOS", "QUANTIDADES: " + quantidade + "- PEDIDOS: " + pedidos+ "- ENTREGAS: " + entregas);
        }
    }

    public Number[] buscarDados(String coluna){
        return getDados(coluna);
    }
}
