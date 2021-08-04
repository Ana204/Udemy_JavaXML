package professor.marcomaddo.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import professor.marcomaddo.appbancodedadosmeusclientes.R;
import professor.marcomaddo.appbancodedadosmeusclientes.controller.ClienteORMController;
import professor.marcomaddo.appbancodedadosmeusclientes.model.ClienteORM;

public class MainActivity extends AppCompatActivity {


    ClienteORMController clienteORMController;
    List<ClienteORM> listaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteORMController = new ClienteORMController();

        ClienteORM orm;
        ClienteORM consulta;

/*          for (int i = 2; i < 10; i++) {
            orm =  new ClienteORM();

            orm.setId(i);
            orm.setNome("Ana Lucia" +i);
            orm.setIdade(2* i);
            orm.setPreco(100 * i);
            orm.setSalario(25 * i);
            orm.setDataCadastro("02/08/2021");
            orm.setHoraCadastro("14:40");
            orm.setAtivo(true);

            clienteORMController.insert(orm);
        }*/

/*        listaClientes = clienteORMController.listar();

        for (ClienteORM obj : listaClientes)
        {
            System.out.println("Cliente: " + obj.getId()+ "" + obj.getNome());
        }*/

        consulta = clienteORMController.getByID(4);

        if (consulta != null){

            System.out.println("Consulta: " + consulta.getId() + " " + consulta.getNome());
        }else {
            System.out.println("NÃO ENCONTRADO !!");
        }

    }
}