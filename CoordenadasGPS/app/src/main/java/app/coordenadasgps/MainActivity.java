package app.coordenadasgps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
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

        if (gpsAtivo) {

            obterCoordenadas();

        } else {

            latitude = 0.00;
            longitude = 0.00;

            valorLatitude.setText(String.valueOf(latitude));
            valorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this,
                    "Coordenadas não Disponíveis", Toast.LENGTH_LONG).show();
        }
    }

    private void obterCoordenadas() {

        boolean permissaoAtiva = permissaoParaLocalizacao();

        if (permissaoAtiva) {

            ultimaLocalizacaoValida();
        }

    }

    private void ultimaLocalizacaoValida() {

        @SuppressLint("MissingPermission")
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {

            // Geopoint
            latitude = location.getLatitude();
            longitude = location.getLongitude();

        } else {

            latitude = 0.00;
            longitude = 0.00;

        }

        valorLatitude.setText(formatarGeopoint(latitude));
        valorLongitude.setText(formatarGeopoint(longitude));

        Toast.makeText(this,
                "Coordenadas obtidas com sucesso", Toast.LENGTH_LONG).show();

    }

    private String formatarGeopoint(double valor){

        DecimalFormat decimalFormat = new DecimalFormat("#.####");

        return decimalFormat.format(valor);

    }


    private boolean permissaoParaLocalizacao() {

        List<String> permissoesNegadas = new ArrayList<>();

        int permissaoNegada;

        for (String permissao : this.permissoesRequeridas) {

            permissaoNegada = ContextCompat.checkSelfPermission(MainActivity.this, permissao);

            if (permissaoNegada != PackageManager.PERMISSION_GRANTED) {
                permissoesNegadas.add(permissao);
            }
        }

        if (!permissoesNegadas.isEmpty()) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    permissoesNegadas.toArray(new String[permissoesNegadas.size()]),
                    APP_PERMISSOES_ID);

            return false;
        } else {
            return true;
        }

    }

}