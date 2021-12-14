package app.grafico.appgraficoxy.model;

public class Vendas {

    private  Number[] quantidadePedidos;
    private  Number[] pedidos;
    private  Number[] entregas;

    public Vendas(){};

    public Number[] getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void setQuantidadePedidos(Number[] quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }

    public Number[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Number[] pedidos) {
        this.pedidos = pedidos;
    }

    public Number[] getEntregas() {
        return entregas;
    }

    public void setEntregas(Number[] entregas) {
        this.entregas = entregas;
    }
}
