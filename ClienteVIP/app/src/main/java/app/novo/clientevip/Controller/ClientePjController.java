package app.novo.clientevip.Controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import app.novo.clientevip.api.AppDataBase;

public class ClientePjController {

   /* private static final String TABELA = ClientePjDataModel.TABELA;
    private ContentValues dados;

    public ClientePjController(@Nullable  Context context) {
        super(context);
    }

    public boolean incluir(ClientePJ obj){

        dados = new ContentValues();

        dados.put(ClientePjDataModel.FK, obj.getClientePfID());
        dados.put(ClientePjDataModel.CNPJ, obj.getCnpj());
        dados.put(ClientePjDataModel.RAZAOSOCIAL, obj.getRazaoSocial());
        dados.put(ClientePjDataModel.DATA_ABERTURA, obj.getDataAbertura());
        dados.put(ClientePjDataModel.SIMPLESNACIONAL, obj.isSimplesNacional());
        dados.put(ClientePjDataModel.MEI, obj.isMei());

        return insert(TABELA, dados);
    }

    public boolean alterar(ClientePJ obj){


        dados = new ContentValues();

        dados.put(ClientePjDataModel.FK, obj.getClienteID());
        dados.put(ClientePjDataModel.ID, obj.getId());
        dados.put(ClientePjDataModel.CNPJ, obj.getCnpj());
        dados.put(ClientePjDataModel.RAZAOSOCIAL, obj.getRazaoSocial());
        dados.put(ClientePjDataModel.DATA_ABERTURA, obj.getDataAbertura());
        dados.put(ClientePjDataModel.SIMPLESNACIONAL, obj.isSimplesNacional());
        dados.put(ClientePjDataModel.MEI, obj.isMei());

        return update(TABELA, dados);
    }

    public boolean deletar(ClientePJ obj){

        dados = new ContentValues();

        //dados.put(ClientePjDataModel.ID, obj.getId());

        return delete(TABELA, obj.getId());
    }

    public List<ClientePJ> listar(){

        return listClientesPessoaJuridica(TABELA);
    }

    public int getLastPK(){

        return getPk(TABELA);
    }*/
}
