package com.example.googlemapsapi

import org.json.JSONObject

data class Categoria(
    val id: String,
    val descripcion: String
) {
    override fun toString(): String {
        return descripcion
    }

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
    override fun toString(): String {
        return descripcion
    }

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
