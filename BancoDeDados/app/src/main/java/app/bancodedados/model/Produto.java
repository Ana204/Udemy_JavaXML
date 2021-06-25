package app.bancodedados.model;

import app.bancodedados.controller.ICrud;

public class Produto implements ICrud {

    private String nome;
    private String codigoProduto;
    private String fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public void incluir() {
        System.out.println("Produto criado com sucesso !!" + getNome() + " - " + getFornecedor() + " - " + getCodigoProduto());
    }

    @Override
    public void alterar() {
        System.out.println("Produto alterado com sucesso !!");
    }

    @Override
    public void deletar() {
        System.out.println("Produto deletado com sucesso !!");
    }

    @Override
    public void listar() {
        System.out.println("Lista de produtos: ");
    }
}
