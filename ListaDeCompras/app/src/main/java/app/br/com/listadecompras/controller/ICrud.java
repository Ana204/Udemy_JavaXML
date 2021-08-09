package app.br.com.listadecompras.controller;

import java.util.List;

public interface ICrud<T> {

    public void insert();
    public void update();
    public void delete();
    public void deleteByID();
    public List<T> listar();
}
