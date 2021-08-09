package app.br.com.listadecompras.controller;

import java.util.List;

import app.br.com.listadecompras.model.Categoria;

public interface ICrud<T> {

    public void insert(T obj);
    public void update(T obj);
    public void delete(T obj);
    public void deleteByID(int id);
    public List<T> listar(int id);
}
