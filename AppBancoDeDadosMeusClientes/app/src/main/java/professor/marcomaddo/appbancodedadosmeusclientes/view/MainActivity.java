package professor.marcomaddo.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import professor.marcomaddo.appbancodedadosmeusclientes.R;
import professor.marcomaddo.appbancodedadosmeusclientes.controller.ClienteORMController;
import professor.marcomaddo.appbancodedadosmeusclientes.model.ClienteORM;

public class MainActivity extends AppCompatActivity {


    ClienteORMController clienteORMController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteORMController = new ClienteORMController();

        ClienteORM orm;

           orm =  new ClienteORM();

            orm.setId(1);
//            orm.setNome("Ana Lucia" +i);
//            orm.setIdade(2* i);
//            orm.setPreco(100 * i);
//            orm.setSalario(25 * i);
//            orm.setDataCadastro("02/08/2021");
//            orm.setHoraCadastro("14:40");
//            orm.setAtivo(true);

            clienteORMController.delete(orm);


    }
}