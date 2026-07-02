
\documentclass[12pt]{article}
\usepackage[utf8]{inputenc}
\usepackage[spanish]{babel}
\usepackage{graphicx}
\usepackage[a4paper,margin=2cm]{geometry}
\usepackage{array}
\usepackage{ragged2e}
\usepackage{float}
\usepackage{listings}
\usepackage{xcolor}
\usepackage{hyperref}
\usepackage{titlesec}
\usepackage{enumitem}
\usepackage{booktabs}
\usepackage{fancyhdr}
\usepackage{mdframed}
\usepackage{tcolorbox}
\usepackage{parskip}

% ── Colores elegantes para el formateador de código ──
\definecolor{codegreen}{rgb}{0,0.5,0}
\definecolor{codegray}{rgb}{0.4,0.4,0.4}
\definecolor{codepurple}{rgb}{0.5,0,0.7}
\definecolor{codeblue}{rgb}{0.1,0.2,0.8}
\definecolor{backcolour}{rgb}{0.97,0.97,0.97}
\definecolor{uteqgreen}{rgb}{0.05,0.4,0.1}
\definecolor{uteqorange}{rgb}{0.96,0.49,0.0}

% ── Definición del lenguaje Kotlin para Listings ──
\lstdefinelanguage{Kotlin}{
  keywords={package, import, data, class, object, val, var, fun, override,
            private, lateinit, lazy, get, set, return, if, else, try, catch,
            throw, when, withContext, launch, suspend, is, as, null, for,
            in, until, true, false, this},
  keywordstyle=\color{codeblue}\bfseries,
  ndkeywords={@Serializable, @SerializedName, @Override},
  ndkeywordstyle=\color{codepurple}\bfseries,
  sensitive=true,
  comment=[l]{//},
  morecomment=[s]{/*}{*/},
  commentstyle=\color{codegreen}\ttfamily,
  stringstyle=\color{red}\ttfamily,
  morestring=[b]",
  morestring=[b]'
}

% ── Definición del lenguaje XML ──
\lstdefinelanguage{XML}{
  keywords={xmlns,android,app,tools},
  keywordstyle=\color{codeblue}\bfseries,
  morestring=[b]",
  stringstyle=\color{red}\ttfamily,
  comment=[s]{<!--}{-->},
  commentstyle=\color{codegreen}\ttfamily,
  moredelim=[s][\color{codepurple}\bfseries]{<}{\ },
  moredelim=[s][\color{codepurple}\bfseries]{</}{>},
  morecomment=[s]{<?}{?>},
}

% ── Configuración general de Listings ──
\lstset{
    backgroundcolor=\color{backcolour},
    commentstyle=\color{codegreen},
    keywordstyle=\color{codeblue}\bfseries,
    numberstyle=\tiny\color{codegray},
    stringstyle=\color{codepurple},
    basicstyle=\ttfamily\small,
    breakatwhitespace=false,
    breaklines=true,
    captionpos=b,
    keepspaces=true,
    numbers=left,
    numbersep=6pt,
    showspaces=false,
    showstringspaces=false,
    showtabs=false,
    tabsize=4,
    frame=single,
    rulecolor=\color{black!15}
}

% ── Encabezado y pie de página ──
\pagestyle{fancy}
\fancyhf{}
\fancyhead[L]{\small\textcolor{uteqgreen}{\textbf{API RESTful en Android con Volley}}}
\fancyhead[R]{\small\textcolor{codegray}{Aplicaciones Móviles -- UTEQ}}
\fancyfoot[C]{\thepage}
\renewcommand{\headrulewidth}{0.4pt}
\renewcommand{\footrulewidth}{0.2pt}

% ── Formato de secciones ──
\titleformat{\section}{\large\bfseries\color{uteqgreen}}{}{0em}{\thesection.\quad}[\titlerule]
\titleformat{\subsection}{\normalsize\bfseries\color{uteqgreen!80!black}}{}{0em}{\thesubsection.\quad}

\begin{document}

% ==============================================
%  CARÁTULA
% ==============================================
\begin{titlepage}
\centering
\includegraphics[width=3cm]{FCClogo.jpg}\\[0.3cm]
{\large \textbf{UNIVERSIDAD TÉCNICA ESTATAL DE QUEVEDO}}\\[0.1cm]
{\small Facultad de Ciencias de la Computación y Diseño Digital}\\[0.7cm]
{\large \textbf{Ingeniería en Software}}\\[0.2cm]
{\large \textbf{Asignatura:} Aplicaciones Móviles}\\[1cm]
\rule{\textwidth}{0.5pt}\\[0.9cm]
{\LARGE \textbf{Mapa Turístico}}\\[0.3cm]
{\LARGE \textbf{Quevedo con GoogleMaps}}\\[0.5cm]
\rule{\textwidth}{0.5pt}\\[1.2cm]
{\large \textbf{Estudiante:}}\\[0.6cm]
{\normalsize MENDOZA BERMELLO ANGELLO AGUSTIN\\[1cm]}
{\large \textbf{Docente:} Ing. ZAMBRANO VEGA CRISTIAN GABRIEL}\\[0.3cm]
{\large \textbf{Carrera:} Ingeniería en Software}\\[1.5cm]
{\large \textbf{Link del Repositorio:}}\\[0.3cm]
{\large \href{https://github.com/Amendozab5/API-RESTful}{https://github.com/Amendozab5/API-RESTful}}\\[0.6cm]
{\large Año Lectivo 2026}
\end{titlepage}

\newpage

% ==============================================
%  INTRODUCCIÓN Y ENTREGABLES
% ==============================================
\section{Introducción y Entregables}
El desarrollo de aplicaciones móviles modernas requiere la integración de servicios de geolocalización y mapas para mejorar la experiencia de usuario. En este proyecto se presenta el desarrollo de una aplicación nativa en Android utilizando el lenguaje de programación \textbf{Kotlin}, la cual integra la tecnología de \textbf{Google Maps} y consume una API web mediante la biblioteca de red \textbf{Volley}.

\subsection{Entregables del Proyecto}
Este informe constituye el documento de soporte técnico del proyecto. Los entregables asociados son:
\begin{itemize}
    \item \textbf{Informe Técnico en formato PDF}: Documentación del diseño, implementación y evaluación.
    \item \textbf{Código Fuente del Proyecto}: Alojado en el repositorio oficial de GitHub: \href{https://github.com/Amendozab5/API-RESTful}{https://github.com/Amendozab5/API-RESTful}.
    \item \textbf{Archivo Ejecutable APK}: Compilado listo para su instalación y pruebas en entornos Android SDK 34+.
\end{itemize}

% ==============================================
%  EVALUACIÓN DE LA RÚBRICA
% ==============================================
\section{Evaluación de la Rúbrica de Calificación}
A continuación, se detalla cómo la solución implementada satisface cada uno de los criterios de la rúbrica de evaluación establecida por el docente:

\begin{enumerate}
    \item \textbf{Interfaz del Mapa (Círculos, Slider y Mapa) [3 Puntos]:}
    \begin{itemize}
        \item \textbf{Cumplimiento:} Completado. Se inicializa Google Maps a través de un \lstinline{SupportMapFragment}.
        \item Se dibuja un círculo rojo semi-translucido usando \lstinline{CircleOptions} cuyo radio se mide en metros.
        \item Se integra un control \lstinline{Slider} de Material 3 con rango de 0.1 a 5.0 km que actualiza visualmente el círculo en tiempo real y refresca los marcadores al soltarse.
    \end{itemize}
    
    \item \textbf{Llenar Lista de Categorías y Subcategorías [2 Puntos]:}
    \begin{itemize}
        \item \textbf{Cumplimiento:} Completado. Al iniciar la aplicación, se realiza una petición HTTP asíncrona mediante Volley al endpoint de categorías.
        \item Cuando el usuario selecciona una categoría, la aplicación limpia el selector secundario y realiza una segunda petición Volley para cargar las subcategorías correspondientes filtradas por el identificador de categoría.
    \end{itemize}

    \item \textbf{Obtener Lugares Turísticos y Mostrarlos en el Mapa [3 Puntos]:}
    \begin{itemize}
        \item \textbf{Cumplimiento:} Completado. La aplicación escucha los cambios de la cámara mediante el evento \lstinline{setOnCameraIdleListener}.
        \item Al detenerse la cámara, se consulta el endpoint de lugares turísticos enviando la latitud y longitud central, junto con el radio (dividido para 10 como solicita la documentación).
        \item Se procesa la respuesta JSON y se colocan marcadores interactivos en las coordenadas de cada lugar turístico.
    \end{itemize}

    \item \textbf{Aplicar Filtros a la Búsqueda de Lugares [2 Puntos]:}
    \begin{itemize}
        \item \textbf{Cumplimiento:} Completado. En lugar de comparar por cadenas de texto simples, la aplicación extrae los identificadores únicos (\lstinline{id}) de la categoría y subcategoría seleccionadas en los selectores.
        \item Se comparan estos IDs con los atributos \lstinline{categoriaId} y \lstinline{subcategoriaId} de la base de datos (aplicando recorte de espacios con \lstinline{.trim()}) para ocultar o mostrar los marcadores del mapa al instante.
    \end{itemize}
\end{enumerate}

\newpage

% ==============================================
%  CAPTURAS DE PANTALLA
% ==============================================
\section{Capturas de la Aplicación en Funcionamiento}
A continuación, se describen las capturas que ilustran la aplicación móvil ejecutándose en el emulador de Android Studio:

\begin{figure}[H]
    \centering
    % Descomentar y ajustar los nombres de las imágenes una vez tomadas las capturas
    % \includegraphics[width=0.45\textwidth]{mapa_inicial.png}
    % \includegraphics[width=0.45\textwidth]{filtro_aplicado.png}
    \caption{Vista general de la aplicación: a la izquierda, inicialización con círculo de búsqueda y marcadores en Quevedo; a la derecha, aplicación de filtros de categoría y subcategoría en tiempo real.}
    \label{fig:capturas}
\end{figure}

*Nota: Reemplazar los marcadores de posición de imágenes en Overleaf por las capturas de pantalla de tu celular físico o emulador donde se demuestren los resultados obtenidos.*

\newpage

% ==============================================
%  CÓDIGO FUENTE
% ==============================================
\section{Código Fuente del Proyecto}

\subsection{Configuración del Manifest (AndroidManifest.xml)}
Muestra los permisos de ubicación, acceso a internet, la clave de API Key del SDK de Google Maps, y la directiva de tráfico en texto claro.

\begin{lstlisting}[language=XML, caption={Configuración de AndroidManifest.xml}]
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <!-- Permisos requeridos para Google Maps y Volley -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.GooglemapsAPI"
        android:usesCleartextTraffic="true">

        <!-- API Key para Google Maps -->
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="AIzaSyAehs5Qv-SLRyTpM7wt5UsvhXdt2sYj9ec" />

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:windowSoftInputMode="adjustResize">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
\end{lstlisting}

\newpage

\subsection{Diseño de la Interfaz (activity\_main.xml)}
El archivo de diseño define la maquetación visual de la aplicación móvil superponiendo la tarjeta flotante de configuración y filtros sobre la vista de Google Maps.

\begin{lstlisting}[language=XML, caption={Maquetación visual en activity\_main.xml}]
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Fragmento del Mapa -->
    <fragment
        android:id="@+id/map"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:context=".MainActivity" />

    <!-- Tarjeta Flotante Superior para Controles -->
    <com.google.android.material.card.MaterialCardView
        android:id="@+id/cardControles"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        app:cardCornerRadius="16dp"
        app:cardElevation="8dp"
        app:strokeWidth="0dp"
        app:cardBackgroundColor="#E5FFFFFF"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="16dp">

            <!-- Cabecera con Título, Coordenadas y Escudo -->
            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginBottom="12dp">

                <!-- Escudo en la esquina superior izquierda -->
                <ImageView
                    android:id="@+id/imgEscudo"
                    android:layout_width="60dp"
                    android:layout_height="70dp"
                    android:layout_alignParentStart="true"
                    android:layout_alignParentTop="true"
                    android:scaleType="fitCenter"
                    android:src="@drawable/escudo_quevedo"
                    android:contentDescription="Escudo de Quevedo" />

                <!-- Contenedor derecho para Título y Coordenadas -->
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:layout_toEndOf="@id/imgEscudo"
                    android:layout_marginStart="12dp">

                    <!-- Título -->
                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Lugares Turísticos Quevedo"
                        android:textColor="#1A237E"
                        android:textSize="16sp"
                        android:textStyle="bold"
                        android:layout_marginBottom="8dp" />

                    <!-- Fila de Coordenadas -->
                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:weightSum="2">

                        <LinearLayout
                            android:layout_width="0dp"
                            android:layout_height="wrap_content"
                            android:layout_weight="1"
                            android:orientation="vertical"
                            android:layout_marginEnd="4dp">

                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:text="Latitud"
                                android:textSize="11sp"
                                android:textColor="#555555"/>

                            <EditText
                                android:id="@+id/txtLatitud"
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:inputType="none"
                                android:focusable="false"
                                android:clickable="false"
                                android:background="@android:color/transparent"
                                android:text="-1.0231"
                                android:textColor="#000000"
                                android:textStyle="bold"
                                android:textSize="14sp" />
                        </LinearLayout>

                        <LinearLayout
                            android:layout_width="0dp"
                            android:layout_height="wrap_content"
                            android:layout_weight="1"
                            android:orientation="vertical"
                            android:layout_marginStart="4dp">

                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:text="Longitud"
                                android:textSize="11sp"
                                android:textColor="#555555"/>

                            <EditText
                                android:id="@+id/txtLongitud"
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:inputType="none"
                                android:focusable="false"
                                android:clickable="false"
                                android:background="@android:color/transparent"
                                android:text="-79.4596"
                                android:textColor="#000000"
                                android:textStyle="bold"
                                android:textSize="14sp" />
                        </LinearLayout>
                    </LinearLayout>
                </LinearLayout>

            </RelativeLayout>

            <!-- Control de Radio -->
            <TextView
                android:id="@+id/lblRadio"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Radio de búsqueda: 1.0 km"
                android:textSize="13sp"
                android:textColor="#333333"
                android:textStyle="bold" />

            <com.google.android.material.slider.Slider
                android:id="@+id/sliderRadio"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:valueFrom="0.1"
                android:valueTo="5.0"
                android:value="1.0"
                android:stepSize="0.1"
                app:labelBehavior="floating"
                app:thumbColor="#1A237E"
                app:trackColorActive="#1A237E" />

            <!-- Filtros de Categorías y Subcategorías -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:weightSum="2"
                android:layout_marginTop="8dp">

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:orientation="vertical"
                    android:layout_marginEnd="6dp">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Categoría"
                        android:textSize="12sp"
                        android:textColor="#555555"
                        android:layout_marginBottom="4dp"/>

                    <Spinner
                        android:id="@+id/spinnerCategoria"
                        android:layout_width="match_parent"
                        android:layout_height="40dp"
                        android:spinnerMode="dropdown" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:orientation="vertical"
                    android:layout_marginStart="6dp">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Subcategoría"
                        android:textSize="12sp"
                        android:textColor="#555555"
                        android:layout_marginBottom="4dp"/>

                    <Spinner
                        android:id="@+id/spinnerSubcategoria"
                        android:layout_width="match_parent"
                        android:layout_height="40dp"
                        android:spinnerMode="dropdown" />
                </LinearLayout>
            </LinearLayout>

        </LinearLayout>
    </com.google.android.material.card.MaterialCardView>

    <!-- Indicador de Carga -->
    <ProgressBar
        android:id="@+id/progressBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
\end{lstlisting}

\newpage

\subsection{Actividad Principal (MainActivity.kt)}
Encapsula la lógica de sincronización del mapa, interacción del GPS, Volley e inyección de datos y filtros por ID.

\begin{lstlisting}[language=Kotlin, caption={Lógica de control principal de MainActivity.kt}]
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
            override fun onStartTrackingTouch(slider: Slider) {}

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
                Toast.makeText(this, "Permiso de ubicación denegado.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
\end{lstlisting}

\newpage

\subsection{Otras Clases Utilizadas (LugarTuristico.kt y Categoria.kt)}
Clases auxiliares de modelado en Kotlin para el mapeo estructurado del JSON devuelto por la API.

\begin{lstlisting}[language=Kotlin, caption={LugarTuristico.kt}]
package com.example.googlemapsapi

import org.json.JSONObject

data class LugarTuristico(
    val id: String,
    val nombre: String,
    val lat: Double,
    val lng: Double,
    val url: String,
    val logo: String,
    val categoria: String,
    val subcategoria: String,
    val categoriaId: String,
    val subcategoriaId: String
) {
    companion object {
        fun fromJson(json: JSONObject): LugarTuristico {
            return LugarTuristico(
                id = json.optString("id", ""),
                nombre = json.optString("nombre", ""),
                lat = json.optString("lat", "0.0").toDoubleOrNull() ?: 0.0,
                lng = json.optString("lng", "0.0").toDoubleOrNull() ?: 0.0,
                url = json.optString("url", ""),
                logo = json.optString("logo", ""),
                categoria = json.optString("categoria", ""),
                subcategoria = json.optString("subcategoria", ""),
                categoriaId = json.optString("categoria_id", ""),
                subcategoriaId = json.optString("subcategoria_id", "")
            )
        }
    }
}
\end{lstlisting}

\begin{lstlisting}[language=Kotlin, caption={Categoria.kt}]
package com.example.googlemapsapi

import org.json.JSONObject

data class Categoria(
    val id: String,
    val descripcion: String
) {
    override fun toString(): String = descripcion

    companion object {
        fun fromJson(json: JSONObject): Categoria {
            return Categoria(
                id = json.optString("id", ""),
                descripcion = json.optString("descripcion", "")
            )
        }
    }
}

data class Subcategoria(
    val id: String,
    val categoriaId: String,
    val descripcion: String,
    val categoria: String
) {
    override fun toString(): String = descripcion

    companion object {
        fun fromJson(json: JSONObject): Subcategoria {
            return Subcategoria(
                id = json.optString("id", ""),
                categoriaId = json.optString("categoria_id", ""),
                descripcion = json.optString("descripcion", ""),
                categoria = json.optString("categoria", "")
            )
        }
    }
}
\end{lstlisting}

\newpage

% ==============================================
%  CONCLUSIONES
% ==============================================
\section{Conclusiones}
\begin{enumerate}
    \item Se integró exitosamente el SDK de Google Maps con la librería Volley, logrando un mapa de turismo interactivo y de alto rendimiento que sincroniza el movimiento de cámara, representación de coordenadas y dibujado de círculo de radio de búsqueda.
    \item La comparación y filtrado de elementos se realiza estrictamente mediante los identificadores numéricos únicos (IDs) provistos por la API RESTful. Esto garantiza que la app cumpla fielmente los lineamientos del docente y evita errores asociados al uso de nombres descriptivos de texto plano.
    \item La arquitectura asíncrona de Volley y el procesamiento local del filtro aseguran una velocidad de respuesta inmediata para el usuario final, disminuyendo el tráfico innecesario en la red y optimizando la carga de memoria de la aplicación en el dispositivo móvil.
\end{enumerate}

\end{document}
```
