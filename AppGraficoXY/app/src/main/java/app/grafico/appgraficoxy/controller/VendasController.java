package app.grafico.appgraficoxy.controller;

public class VendasController {


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
}
