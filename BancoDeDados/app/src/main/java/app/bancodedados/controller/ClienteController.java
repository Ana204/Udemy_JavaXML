package app.bancodedados.controller;

import android.content.Context;

import app.bancodedados.datasource.DataBase;

public class ClienteController extends DataBase {

    public ClienteController(Context context) {
        super(context);

        System.out.println("Banco conectado com controller Cliente !");
    }
}
