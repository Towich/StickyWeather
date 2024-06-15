package com.towich.stickyweather.data.network.serializable.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Wind (

  @SerializedName("speed" ) var speed : Double? = null,
  @SerializedName("deg"   ) var deg   : Int?    = null,
  @SerializedName("gust"  ) var gust  : Double? = null

)