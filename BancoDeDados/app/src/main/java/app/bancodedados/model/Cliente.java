package app.bancodedados.model;

import app.bancodedados.controller.ICrud;

public class Cliente implements ICrud {

    private String nome;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void incluir() {
        System.out.println("Cliente Salvo com sucesso !!");
    }

    @Override
    public void alterar() {

        System.out.println("Cliente alterado com sucesso !!");
    }

    @Override
    public void deletar() {

        System.out.println("Cliente deletado com sucesso !!");
    }

    @Override
    public void listar() {

        System.out.println("Lista de clientes: ");
    }
}
