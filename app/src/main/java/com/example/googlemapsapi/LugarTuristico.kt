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
