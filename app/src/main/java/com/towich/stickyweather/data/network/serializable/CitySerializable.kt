package com.towich.stickyweather.data.network.serializable

import com.towich.stickyweather.data.model.CityModel
import kotlinx.serialization.Serializable

@Serializable
data class CitySerializable(
    val id: String,
    val city: String,
    val latitude: String,
    val longitude: String
){
    fun convertToCityModel(): CityModel {
        return CityModel(
            id,
            if(city == "") "Безымянный" else city,
            latitude,
            longitude)
    }
}
