package app.br.com.listadecompras.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

import app.br.com.listadecompras.R;
import app.br.com.listadecompras.controller.CategoriaController;
import app.br.com.listadecompras.controller.ProdutoController;
import app.br.com.listadecompras.model.Categoria;
import app.br.com.listadecompras.model.Produto;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;

    NavigationView navigationView;

    Menu menu;
    MenuItem meusProdutos;
    MenuItem minhasCompras;
    MenuItem compartilhar;

    TextView txtTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =   findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action Button Clicado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        txtTitulo = findViewById(R.id.txtTitulo);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.content_fragment, new MinhasComprasFragment()).commit();

        manterCategoria();
        manterProduto();

    }

    private void manterProduto() {

        ProdutoController produto = new ProdutoController();

        Produto obj = new Produto();

        obj.setNomeDoProduto("Novo Produto");
        obj.setUnidadeDeMedida("UN");
        obj.setQuantidade(19.5);
        obj.setPrecoPago(15.90);
        obj.setDataDaInclusao(new Date());
        obj.setCodigoDeBarras("999000000");
        obj.setId(2);
/*
        List<Produto> listaDeProduto = produto.listar(obj);


        for (Produto o: listaDeProduto){

            System.out.println("LISTA DE PRODUTO " + o.getId() + " - " + o.getNomeDoProduto());
        }*/



    }

    private void manterCategoria() {

        CategoriaController categoria = new CategoriaController();

        Categoria obj = new Categoria();

        obj.setNomeDaCategoria("Registro");
        obj.setId(3);

/*        List<Categoria> listaDeCategoria = categoria.listar(obj);

        for (Categoria o: listaDeCategoria) {

            System.out.println("LISTA: " + o.getId() + " " + o.getNomeDaCategoria());

        }*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.meus_produtos) {

            menu = navigationView.getMenu();

            meusProdutos = menu.findItem(R.id.meus_produtos);
            meusProdutos.setTitle("Preto Ativado");

            minhasCompras = menu.findItem(R.id.minhas_compras);
            minhasCompras.setTitle("Vermelho");

            compartilhar = menu.findItem(R.id.compartilhar);
            compartilhar.setTitle("Azul");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new MeusProdutosFragment()).commit();

        } else if (id == R.id.minhas_compras) {

            menu = navigationView.getMenu();

            meusProdutos = menu.findItem(R.id.meus_produtos);

            meusProdutos.setTitle("Preto");

            minhasCompras = menu.findItem(R.id.minhas_compras);
            minhasCompras.setTitle("Vermelho Ativado");

            compartilhar = menu.findItem(R.id.compartilhar);
            compartilhar.setTitle("Azul");


            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new MinhasComprasFragment()).commit();

        } else if (id == R.id.compartilhar) {

            menu = navigationView.getMenu();

            meusProdutos = menu.findItem(R.id.meus_produtos);
            meusProdutos.setTitle("Preto");

            minhasCompras = menu.findItem(R.id.minhas_compras);
            minhasCompras.setTitle("Vermelho");

            compartilhar = menu.findItem(R.id.compartilhar);
            compartilhar.setTitle("Azul Ativado");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new CompartilharFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
