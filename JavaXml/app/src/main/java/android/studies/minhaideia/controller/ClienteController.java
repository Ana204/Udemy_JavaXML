package android.studies.minhaideia.controller;

import android.studies.minhaideia.core.AppUtil;

public class ClienteController {

    //String TAG = "SYSTEM";
    String versaoApp;

    public ClienteController(){

        this.versaoApp = AppUtil.versaoDoAplicativo();

        System.out.println("Versão APP: " + versaoApp);
        //Log.i(TAG, "ClienteController: Versão App: " + versaoApp);
    }
}
