package app.novo.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, cidades));

        ListView cidadesListView = getListView();
    }
}