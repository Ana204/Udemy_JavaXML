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

    public Number[] popularQuantidadePedidos(){

        Number[] dadosQuantidadesPedidos =  {1, 2, 3, 6, 7, 8, 9, 10, 13, 14};

        return dadosQuantidadesPedidos;
    }

    public Number[] popularPedidos(){

        Number[] dadosPedidos = {1, 4, 2, 8, 4, 16, 8, 32, 16, 64};

        return dadosPedidos;
    }

    public Number[] popularEntregas(){

        Number[] dadosEntregas = {5, 2, 10, 5, 20, 10, 40, 20, 80, 40};

        return dadosEntregas;
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
}
