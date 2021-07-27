package app.modelo.coordenadasgpdkotlin

import android.Manifest
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var permissoesRequeridas = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    val APP_PERMISSOES_ID = 2021

    var valorLatitude: TextView? = null
    var valorLongitude: TextView? = null

    var latitude:Double = 0.00
    var longitude:Double = 0.00

    var locationManager: LocationManager? = null

    var gpsAtivo:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    private fun obterCoordenadas(){}

    private fun permissaoParaLocalizacao(): Boolean{

        return true
    }

    private fun ultimaLocalizacaoValida(){}

    private fun formatarGeopoint(valor: Double): String? {

        return ""
    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("AQUII EM SP"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.uiSettings.setZoomControlsEnabled(true)
        mMap.setMinZoomPreference(9.5f)

    }
}