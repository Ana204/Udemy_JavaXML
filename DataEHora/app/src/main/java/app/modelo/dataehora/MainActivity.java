package app.modelo.dataehora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import app.modelo.dataehora.api.AppUtil;

public class MainActivity extends AppCompatActivity {

    TextView data;
    TextView hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.data);
        hora = findViewById(R.id.hora);

        data.setText(AppUtil.getDataAtual());
        hora.setText(AppUtil.getHoraAtual());
    }
}