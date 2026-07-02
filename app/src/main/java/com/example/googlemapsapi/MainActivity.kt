package com.example.googlemapsapi

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.slider.Slider
import org.json.JSONObject
import java.util.Locale

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapa: GoogleMap
    private var lat: Double = -1.02313
    private var lng: Double = -79.459561
    private var radio: Float = 1.0f
    private var circulo: Circle? = null

    private lateinit var sliderRadio: Slider
    private lateinit var txtLatitud: EditText
    private lateinit var txtLongitud: EditText
    private lateinit var lblRadio: TextView
    private lateinit var spinnerCategoria: Spinner
    private lateinit var spinnerSubcategoria: Spinner
    private lateinit var progressBar: ProgressBar

    private val markers = ArrayList<Marker>()
    private val markerToPlaceMap = HashMap<Marker, LugarTuristico>()
    private var todosLosLugares = ArrayList<LugarTuristico>()

    private lateinit var requestQueue: RequestQueue

    private val LOCATION_PERMISSION_REQUEST_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLatitud = findViewById(R.id.txtLatitud)
        txtLongitud = findViewById(R.id.txtLongitud)
        sliderRadio = findViewById(R.id.sliderRadio)
        lblRadio = findViewById(R.id.lblRadio)
        spinnerCategoria = findViewById(R.id.spinnerCategoria)
        spinnerSubcategoria = findViewById(R.id.spinnerSubcategoria)
        progressBar = findViewById(R.id.progressBar)

        requestQueue = Volley.newRequestQueue(this)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        configurarListeners()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapa = googleMap

        mapa.uiSettings.isZoomControlsEnabled = true
        mapa.uiSettings.isMyLocationButtonEnabled = true

        val puntoInicial = LatLng(lat, lng)
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(puntoInicial, 15f))

        comprobarPermisosUbicacion()

        actualizarInterfaz(buscarLugares = false)

        cargarCategorias()
        cargarLugaresTuristicos()

        mapa.setOnCameraIdleListener {
            val center = mapa.cameraPosition.target
            lat = center.latitude
            lng = center.longitude

            actualizarInterfaz(buscarLugares = true)
        }

        mapa.setOnMarkerClickListener { marker ->
            marker.showInfoWindow()
            true
        }

        mapa.setOnInfoWindowClickListener { marker ->
            val lugar = markerToPlaceMap[marker]
            if (lugar != null && lugar.url.isNotEmpty()) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(lugar.url))
                    startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(this, "No se puede abrir el enlace del lugar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun configurarListeners() {

        sliderRadio.addOnChangeListener { _, value, _ ->
            radio = value
            lblRadio.text = String.format(Locale.US, "Radio de búsqueda: %.1f km", radio)

            redibujarCirculo()
        }

        sliderRadio.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {

            }

            override fun onStopTrackingTouch(slider: Slider) {
                radio = slider.value
                actualizarInterfaz(buscarLugares = true)
            }
        })


        spinnerCategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val categoriaSel = spinnerCategoria.selectedItem as? Categoria
                if (categoriaSel != null) {
                    if (categoriaSel.id == "0") {

                        configurarSpinnerSubcategorias(emptyList())
                        filtrarYMostrarLugares()
                    } else {

                        cargarSubcategorias(categoriaSel.id)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        spinnerSubcategoria.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                filtrarYMostrarLugares()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun actualizarInterfaz(buscarLugares: Boolean) {
        txtLatitud.setText(String.format(Locale.US, "%.6f", lat))
        txtLongitud.setText(String.format(Locale.US, "%.6f", lng))
        lblRadio.text = String.format(Locale.US, "Radio de búsqueda: %.1f km", radio)

        redibujarCirculo()

        if (buscarLugares) {
            cargarLugaresTuristicos()
        }
    }

    private fun redibujarCirculo() {
        circulo?.remove()

        val centro = LatLng(lat, lng)

        val radioMetros = radio * 1000.0

        val circleOptions = CircleOptions()
            .center(centro)
            .radius(radioMetros)
            .strokeWidth(3f)
            .strokeColor(Color.RED)
            .fillColor(Color.argb(35, 255, 0, 0))

        circulo = mapa.addCircle(circleOptions)
    }



    private fun cargarCategorias() {
        val url = "http://35.153.103.86/turismo10022025/categoria/getlistadoCB"
        progressBar.visibility = View.VISIBLE

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                progressBar.visibility = View.GONE
                val categoriasList = ArrayList<Categoria>()
                // Agregar opción por defecto
                categoriasList.add(Categoria("0", "Todas las categorías"))

                for (i in 0 until response.length()) {
                    val item = response.getJSONObject(i)
                    categoriasList.add(Categoria.fromJson(item))
                }

                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoriasList)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerCategoria.adapter = adapter
            },
            { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Error al cargar categorías: ${error.message}", Toast.LENGTH_LONG).show()
            }
        )
        requestQueue.add(request)
    }

    private fun cargarSubcategorias(categoriaId: String) {
        val url = "http://35.153.103.86/turismo10022025/subcategoria/getlistadoCB/$categoriaId"
        progressBar.visibility = View.VISIBLE

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                progressBar.visibility = View.GONE
                val subcategoriasList = ArrayList<Subcategoria>()
                subcategoriasList.add(Subcategoria("0", categoriaId, "Todas las subcategorías", ""))

                for (i in 0 until response.length()) {
                    val item = response.getJSONObject(i)
                    subcategoriasList.add(Subcategoria.fromJson(item))
                }

                configurarSpinnerSubcategorias(subcategoriasList)
            },
            { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Error al cargar subcategorías: ${error.message}", Toast.LENGTH_LONG).show()
            }
        )
        requestQueue.add(request)
    }

    private fun configurarSpinnerSubcategorias(lista: List<Subcategoria>) {
        val subcategorias = if (lista.isEmpty()) {
            listOf(Subcategoria("0", "", "Todas las subcategorías", ""))
        } else {
            lista
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subcategorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSubcategoria.adapter = adapter
    }

    private fun cargarLugaresTuristicos() {

        val radioUrl = radio / 10.0
        val url = "http://35.153.103.86/turismo10022025/lugar_turistico/json_getlistadoMapa?lat=$lat&lng=$lng&radio=$radioUrl"
        progressBar.visibility = View.VISIBLE

        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                progressBar.visibility = View.GONE
                todosLosLugares.clear()

                val jsonLista = response.optJSONArray("data")
                if (jsonLista != null) {
                    for (i in 0 until jsonLista.length()) {
                        val item = jsonLista.getJSONObject(i)
                        todosLosLugares.add(LugarTuristico.fromJson(item))
                    }
                }
                filtrarYMostrarLugares()
            },
            { error ->
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Error al cargar lugares turísticos: ${error.message}", Toast.LENGTH_LONG).show()
            }
        )
        requestQueue.add(request)
    }

    private fun filtrarYMostrarLugares() {
        if (!::mapa.isInitialized) return

        for (marker in markers) {
            marker.remove()
        }
        markers.clear()
        markerToPlaceMap.clear()

        val categoriaSel = spinnerCategoria.selectedItem as? Categoria
        val selectedCategoryId = if (categoriaSel == null || categoriaSel.id == "0") "" else categoriaSel.id

        val subcategoriaSel = spinnerSubcategoria.selectedItem as? Subcategoria
        val selectedSubcategoryId = if (subcategoriaSel == null || subcategoriaSel.id == "0") "" else subcategoriaSel.id


        for (lugar in todosLosLugares) {
            val coincideCategoria = selectedCategoryId.isEmpty() || lugar.categoriaId.trim() == selectedCategoryId.trim()
            val coincideSubcategoria = selectedSubcategoryId.isEmpty() || lugar.subcategoriaId.trim() == selectedSubcategoryId.trim()

            if (coincideCategoria && coincideSubcategoria) {
                val posicion = LatLng(lugar.lat, lugar.lng)
                val markerOptions = MarkerOptions()
                    .position(posicion)
                    .title(lugar.nombre)
                    .snippet("${lugar.categoria} | ${lugar.subcategoria}")

                val marker = mapa.addMarker(markerOptions)
                if (marker != null) {
                    markers.add(marker)
                    markerToPlaceMap[marker] = lugar
                }
            }
        }

        Toast.makeText(
            this@MainActivity,
            "Se muestran ${markers.size} de ${todosLosLugares.size} lugares turísticos",
            Toast.LENGTH_SHORT
        ).show()
    }



    private fun comprobarPermisosUbicacion() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            enableMyLocation()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    private fun enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mapa.isMyLocationEnabled = true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableMyLocation()
            } else {
                Toast.makeText(this, "Permiso de ubicación denegado. Se usará posición predeterminada.", Toast.LENGTH_LONG).show()
            }
        }
    }
}