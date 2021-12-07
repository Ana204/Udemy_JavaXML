package app.novo.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

   static final String[] cidades = new String[]{
            "Campo Grande - MS",
            "São Paulo - SP",
            "Brasília - DF",
            "Rio de Janeiro - RJ",
            "Salvador - BH",
            "Belo Horizonte - MG",
            "Goiânia - GA",
            "Belém - PR",
            "João Pessoa - PB",
            "Maringá - PR",
            "Praia Grande - SP",
            "Dourados - MS",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, cidades));

        ListView cidadesListView = getListView();

        cidadesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "CIDADE - " + " " +cidades[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}