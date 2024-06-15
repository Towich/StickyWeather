package com.towich.stickyweather.data.network.serializable.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Rain (

  @SerializedName("1h" ) var h : Double? = null

)