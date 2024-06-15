package com.towich.stickyweather.data.network.serializable.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Clouds (

  @SerializedName("all" ) var all : Int? = null

)