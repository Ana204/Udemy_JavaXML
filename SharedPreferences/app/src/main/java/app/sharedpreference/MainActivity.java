package app.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NOME = "App_sharedPref";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Rodando !!");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 8787654;
        precoProduto = 997.97f;
        estoque = true;

        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoqueProduto", estoque);

        //criando os dados
        dados.apply();

        //para limpar os dados
        //dados.clear();
        //dados.apply();

        //deletar os dados
        //dados.remove("estoqueProduto");
        //dados.apply();


        System.out.println("Dados para serem salvos: " + nomeProduto + "-" + codigoProduto + "-" + precoProduto + "-" + estoque);

        System.out.println("Pegando os dados: " + sharedPreferences.getString("nomeProduto", "Fora de estoque")
        + sharedPreferences.getInt("codigoProduto", -1)
        + sharedPreferences.getFloat("precoProduto", -1.0f)
        + sharedPreferences.getBoolean("estoqueProduto", false));




    }
}