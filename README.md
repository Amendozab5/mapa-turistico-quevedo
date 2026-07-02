# 🗺️ Mapa Turístico Quevedo — Google Maps + Volley

Aplicación nativa Android desarrollada en **Kotlin** para visualizar y filtrar lugares turísticos de la ciudad de Quevedo, Ecuador. Integra **Google Maps SDK** y realiza todas las peticiones de red mediante **Volley**.

---

## 📱 Funcionalidades

- 🗺️ **Mapa interactivo de Google Maps** con posicionamiento inicial en Quevedo.
- 🔴 **Círculo de radio dinámico**: se redibuja en tiempo real al desplazarte o cambiar el radio.
- 🎚️ **Slider de Material Design** para ajustar el radio de búsqueda (0.1 a 5.0 km).
- 📡 **Carga automática de lugares turísticos** mediante Volley cada vez que la cámara se detiene.
- 🏷️ **Filtros por Categoría y Subcategoría** que comparan por ID único en tiempo real.
- 📍 **Marcadores interactivos**: toca el marcador para ver el nombre y detalle del lugar.
- 🔗 **Enlace directo**: toca la ventana de información del marcador para abrir Google Maps del lugar.
- 📍 Coordenadas (Latitud/Longitud) actualizadas en tiempo real en la tarjeta superior.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión |
|---|---|
| Kotlin | 2.x |
| Google Maps SDK for Android | 18.2.0 |
| Google Play Services Location | 21.3.0 |
| Volley | 1.2.1 |
| Material Design 3 | 1.14.0 |
| Android Gradle Plugin | 9.2.1 |

---

## 🌐 Endpoints de la API

La aplicación consume los siguientes servicios REST del servidor de la UTEQ:

```
GET /turismo10022025/lugar_turistico/json_getlistadoMapa?lat={lat}&lng={lng}&radio={radio}
GET /turismo10022025/categoria/getlistadoCB
GET /turismo10022025/subcategoria/getlistadoCB/{categoria_id}
```

---

## ⚙️ Configuración del Proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/Amendozab5/API-RESTful.git
cd API-RESTful
```

### 2. Configurar la API Key de Google Maps

La API Key **no está incluida** en el repositorio por seguridad. Debes crearla tú mismo:

1. Ve a [Google Cloud Console](https://console.cloud.google.com/).
2. Crea un proyecto y habilita el **Maps SDK for Android**.
3. Genera una **API Key** en la sección de Credenciales.
4. Abre (o crea) el archivo `local.properties` en la raíz del proyecto y agrega:

```properties
MAPS_API_KEY=TU_CLAVE_DE_API_AQUÍ
```

> ⚠️ **IMPORTANTE:** El archivo `local.properties` está incluido en el `.gitignore` y **nunca** debe subirse al repositorio público para proteger tu clave.

### 3. Abrir en Android Studio y ejecutar

- Abre el proyecto en Android Studio.
- Haz clic en **Sync Project with Gradle Files** (icono del elefante).
- Ejecuta la app en un emulador o dispositivo físico con Android 9+ (API 34+).

---

## 📁 Estructura del Proyecto

```
app/src/main/
├── java/com/example/googlemapsapi/
│   ├── MainActivity.kt        # Lógica principal: Mapa, Volley, Filtros
│   ├── LugarTuristico.kt      # Modelo de datos de lugar turístico
│   └── Categoria.kt           # Modelos de Categoría y Subcategoría
├── res/
│   ├── layout/
│   │   └── activity_main.xml  # Diseño: Mapa + Tarjeta flotante + Controles
│   └── drawable/
│       └── escudo_quevedo.jpg # Escudo de la ciudad
└── AndroidManifest.xml        # Permisos, API Key placeholder y configuración
```

---

## 📸 Capturas de Pantalla

| Mapa con círculo de radio | Filtros aplicados |
|---|---|
| Arrastre el mapa para actualizar | Selecciona categoría y subcategoría |

---

## 👨‍💻 Información del Proyecto

| Campo | Detalle |
|---|---|
| **Estudiante** | Mendoza Bermello Angello Agustin |
| **Correo** | amendozab5@uteq.edu.ec |
| **Docente** | Ing. Zambrano Vega Cristian Gabriel |
| **Asignatura** | Aplicaciones Móviles |
| **Carrera** | Ingeniería en Software |
| **Universidad** | Universidad Técnica Estatal de Quevedo (UTEQ) |
| **Año Lectivo** | 2026 |

---

## 📄 Licencia

Proyecto académico desarrollado para la asignatura de Aplicaciones Móviles de la UTEQ. Todos los derechos reservados © 2026.
