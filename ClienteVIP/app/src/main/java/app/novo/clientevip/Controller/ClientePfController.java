package app.novo.clientevip.Controller;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

import app.novo.clientevip.api.AppDataBase;
import app.novo.clientevip.datamodel.ClientePfDataModel;
import app.novo.clientevip.model.ClientePF;

public class ClientePfController extends AppDataBase {

    private static final String TABELA = ClientePfDataModel.TABELA;
    private ContentValues dados;

    public ClientePfController(@Nullable Context context) {
        super(context);
    }

    public boolean incluir(ClientePF obj) {

        dados = new ContentValues();

        dados.put(ClientePfDataModel.FK, obj.getClienteID());
        dados.put(ClientePfDataModel.CPF, obj.getCpf());
        dados.put(ClientePfDataModel.NOME_COMPLETO, obj.getNomeCompleto());


        return insert(TABELA, dados);
    }

    public boolean alterar(ClientePF obj) {

        dados = new ContentValues();

        dados.put(ClientePfDataModel.ID, obj.getId());
        dados.put(ClientePfDataModel.CPF, obj.getCpf());
        dados.put(ClientePfDataModel.NOME_COMPLETO, obj.getNomeCompleto());

        return update(TABELA, dados);
    }

    public boolean deletar(ClientePF obj) {

        dados = new ContentValues();

        //dados.put(ClientePfDataModel.ID, obj.getId());

        return delete(TABELA, obj.getId());
    }

    public List<ClientePF> listar() {

        return listClientesPessoaFisica(TABELA);
    }

    public int getUltimo() {

        return getLastPk(TABELA);
    }

    //idFK vindo como 0
    public ClientePF getClientePFByFK(int idFK) {

        return getClientePFByFK(ClientePfDataModel.TABELA, idFK);
    }
}
