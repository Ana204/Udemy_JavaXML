package app.coordenadasgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] permissoesRequeridas = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS
    };

    public static final int APP_PERMISSOES_ID = 2021;

    TextView valorLatitude, valorLongitude;

    LocationManager locationManager;
    double latitude, longitude;
    boolean gpsAtivo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorLatitude = findViewById(R.id.valorLatitude);
        valorLongitude = findViewById(R.id.valorLongitude);

        locationManager = (LocationManager) getApplication().getSystemService(Context.LOCATION_SERVICE);

        gpsAtivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(gpsAtivo){
            obterCoordenadas();
        }else {
            latitude = 0.00;
            longitude = 0.00;

            valorLatitude.setText(String.valueOf(latitude));
            valorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this, "ATIVE O SEU GPS", Toast.LENGTH_LONG).show();
        }
    }

    private void obterCoordenadas() {

        boolean permissaoAtiva = permissaoParaLocalizacao();

        if (permissaoAtiva){

            ultimaLocalizacaoValida();
        }

    }

    private void ultimaLocalizacaoValida() {

        latitude = 1.98;
        longitude = -1.67;

        valorLatitude.setText(String.valueOf(latitude));
        valorLongitude.setText(String.valueOf(longitude));

        Toast.makeText(this, "GPS ATIVADO", Toast.LENGTH_LONG).show();
    }


    private boolean permissaoParaLocalizacao() {

        Toast.makeText(this, "APP SEM PERMISSÃO", Toast.LENGTH_LONG).show();

        List<String> permissoesNegadas = new ArrayList<>();

        int permissaoNegada;

        for (String permissao : this.permissoesRequeridas) {

            permissaoNegada = ContextCompat.checkSelfPermission(MainActivity.this, permissao);

            if(permissaoNegada != PackageManager.PERMISSION_GRANTED){
                permissoesNegadas.add(permissao);
            }
        }

        if (!permissoesNegadas.isEmpty()) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    permissoesNegadas.toArray(new String[permissoesNegadas.size()]), APP_PERMISSOES_ID);

            return false;
        }else {
            return true;
        }

    }


}