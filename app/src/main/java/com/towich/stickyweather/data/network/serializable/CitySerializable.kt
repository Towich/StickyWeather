package com.towich.stickyweather.data.network.serializable

import androidx.compose.ui.res.stringResource
import com.towich.stickyweather.App
import com.towich.stickyweather.R
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
            if(city == "") App.context.getString(R.string.unknown_city) else city,
            latitude,
            longitude)
    }
}
