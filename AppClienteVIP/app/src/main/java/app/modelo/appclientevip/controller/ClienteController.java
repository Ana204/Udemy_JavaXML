package app.modelo.appclientevip.controller;

import android.content.Context;
import androidx.annotation.Nullable;
import app.modelo.appclientevip.api.AppDataBase;

public class ClienteController extends AppDataBase {

    public ClienteController(@Nullable  Context context) {
        super(context);
    }

    public boolean incluir(){

        return true;
    }

    public boolean alterar(){

        return true;
    }

    public boolean deletar(){

        return true;
    }

    public boolean listar(){

        return true;
    }
}
