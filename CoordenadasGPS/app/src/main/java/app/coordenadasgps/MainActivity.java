package app.coordenadasgps;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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

        boolean permissaoAtiva = true;

        if (permissaoAtiva){

            ultimaLocalizacaoValida();
        }else {
            permissaoParaLocalizacao();
        }

    }

    private void ultimaLocalizacaoValida() {

        latitude = 1.98;
        longitude = -1.67;

        valorLatitude.setText(String.valueOf(latitude));
        valorLongitude.setText(String.valueOf(longitude));

        Toast.makeText(this, "GPS ATIVADO", Toast.LENGTH_LONG).show();
    }


    private void permissaoParaLocalizacao() {

        Toast.makeText(this, "APP SEM PERMISSÃO", Toast.LENGTH_LONG).show();

    }


}