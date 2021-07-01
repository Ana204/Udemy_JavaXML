package app.bancodedados.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import app.bancodedados.R;
import app.bancodedados.controller.ClienteController;
import app.bancodedados.controller.ProdutoController;
import app.bancodedados.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
   // ProdutoController produtoController;

    Cliente obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteController = new ClienteController(getApplicationContext());

        obj = new Cliente();
        obj.setId(3);
        obj.setNome("Ana");
        obj.setEmail("anagomes@.com");
        obj.setSenha("654321");

/*        if ( clienteController.incluir(obj))
        {
            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome()+ " incluído com sucesso", Toast.LENGTH_SHORT).show();

            System.out.println("Cliente " +obj.getNome() + "incluido com sucesso");
        }
        else {
            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome()+ " Falha ao incluir", Toast.LENGTH_SHORT).show();

            System.out.println("Cliente " +obj.getNome() + "Falha ao incluir");
        }*/

//        if (clienteController.deletar(obj.getId()))
//        {
//            Toast.makeText(MainActivity.this, "Cliente " +obj.getId()+ " excluido com sucesso", Toast.LENGTH_SHORT).show();
//
//            System.out.println("Cliente " +obj.getId() + "excluido com sucesso");
//        }
//        else {
//            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome()+ " Falha ao excluir", Toast.LENGTH_SHORT).show();
//
//            System.out.println("Cliente " +obj.getNome() + "Falha ao excluir");
//        }

    /*    if (clienteController.alterar(obj))
        {
            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome() + "Atualizado com sucesso", Toast.LENGTH_SHORT).show();

            System.out.println("Cliente " + obj.getNome() + "Atualizado com sucesso");
        }
        else {

            Toast.makeText(MainActivity.this, "Cliente " +obj.getNome() + "Falha ao Atualizar", Toast.LENGTH_SHORT).show();
            System.out.println("Cliente " + obj.getNome() + "Falha ao atualizar");
        }*/


        for ( Cliente obj : clienteController.listar() ) {

            System.out.println("CLIENTES: " + obj.getNome() + "-" + obj.getEmail() + "-" + obj.getSenha() + "-" + obj.getId());
        }

    }
}