package app.bancodedados.controller;

public interface ICrud<T> {

    public void incluir(T obj);

    public void alterar(T obj);

    public void deletar(T obj);

    public void listar(T obj);
}
