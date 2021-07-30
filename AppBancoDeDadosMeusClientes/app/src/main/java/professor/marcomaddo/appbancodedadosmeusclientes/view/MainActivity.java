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

        ClienteORM orm = new ClienteORM();

        orm.setNome("Ana");
        orm.setIdade(20);
        orm.setPreco(12.97);
        orm.setSalario(99999);
        orm.setDataCadastro("30/07/2021");
        orm.setHoraCadastro("14:48");

        clienteORMController.insert(orm);
    }
}