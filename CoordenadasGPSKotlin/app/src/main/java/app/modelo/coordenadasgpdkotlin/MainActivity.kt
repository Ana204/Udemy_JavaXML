package app.modelo.coordenadasgpdkotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.DecimalFormat

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var permissoesRequeridas = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    val APP_PERMISSOES_ID = 2021

    var valorLatitude: TextView? = null
    var valorLongitude: TextView? = null

    var latitude: Double =  23.5
    var longitude: Double = 46.6

    var locationManager: LocationManager? = null

    var gpsAtivo: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valorLatitude = findViewById(R.id.valorLatitude)
        valorLongitude = findViewById(R.id.valorLongitude)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationManager = application.getSystemService(LOCATION_SERVICE) as LocationManager
        gpsAtivo = locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (gpsAtivo) {

            obterCoordenadas()

        } else {
            latitude = -23.5489
            longitude = -46.6388

            valorLatitude!!.setText(formatarGeopoint(latitude))
            valorLongitude!!.setText(formatarGeopoint(longitude))

            Toast.makeText(
                this,
                "Coordenadas não Disponíveis", Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun obterCoordenadas() {

        val permissaoAtiva: Boolean = permissaoParaLocalizacao()

        if (permissaoAtiva) {
            ultimaLocalizacaoValida()
        }


    }

    private fun permissaoParaLocalizacao(): Boolean {

        Toast.makeText(
            this,
            "Verificando permissões", Toast.LENGTH_LONG
        ).show()

        val permissoesNegadas: MutableList<String> = ArrayList()

        var permissaoNegada: Int

        for (permissao in permissoesRequeridas) {

            permissaoNegada = ContextCompat.checkSelfPermission(this@MainActivity, permissao)

            if (permissaoNegada != PackageManager.PERMISSION_GRANTED) {
                permissoesNegadas.add(permissao)
            }

        }

        return if (!permissoesNegadas.isEmpty()) {

            ActivityCompat.requestPermissions(
                this@MainActivity,
                permissoesNegadas.toTypedArray(), APP_PERMISSOES_ID
            )
            false
        } else {
            true
        }
    }


    private fun ultimaLocalizacaoValida() {
        @SuppressLint("MissingPermission")
        val location = locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        if (location != null) {

            latitude = location.latitude
            longitude = location.longitude
        } else {
            latitude = 0.00
            longitude = 0.00
        }

        valorLatitude!!.setText(formatarGeopoint(latitude))
        valorLongitude!!.setText(formatarGeopoint(longitude))

        Toast.makeText(
            this,
            "Coordenadas obtidas com sucesso", Toast.LENGTH_LONG
        ).show()
    }

    private fun formatarGeopoint(valor: Double): String? {

        val decimalFormat = DecimalFormat("#.####")

        return decimalFormat.format(valor)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        val sydney = LatLng(  -23.5489,  -46.6388)
        mMap.addMarker(MarkerOptions().position(sydney).title("Celular localizado AQUI !"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.uiSettings.setZoomControlsEnabled(true)
        mMap.setMinZoomPreference(9.5f)

    }
}