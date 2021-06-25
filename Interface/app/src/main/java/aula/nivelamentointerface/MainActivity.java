package aula.nivelamentointerface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cliente cliente = new Cliente();
        Produto produto = new Produto();

        cliente.setNome("Ana Gomes");
        cliente.setEmail("anaGomes@gmail.com");
        cliente.setSenha("123456");

        //cliente.incluir();
        //cliente.alterar();
        //cliente.deletar();
        //cliente.listar();


        produto.setNome("Notbook");
        produto.setFornecedor("ACER");
        produto.setCodigoProduto("89897766");

        produto.incluir();
       // produto.deletar();
       // produto.alterar();
       // produto.listar();



    }
}