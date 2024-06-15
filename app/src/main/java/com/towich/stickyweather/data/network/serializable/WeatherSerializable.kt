package com.towich.stickyweather.data.network.serializable

import com.google.gson.annotations.SerializedName
import com.towich.stickyweather.data.network.serializable.weather.Clouds
import com.towich.stickyweather.data.network.serializable.weather.Coord
import com.towich.stickyweather.data.network.serializable.weather.Main
import com.towich.stickyweather.data.network.serializable.weather.Rain
import com.towich.stickyweather.data.network.serializable.weather.Sys
import com.towich.stickyweather.data.network.serializable.weather.Weather
import com.towich.stickyweather.data.network.serializable.weather.Wind
import kotlinx.serialization.Serializable


@Serializable
data class WeatherSerializable (

    @SerializedName("coord"      ) var coord      : Coord?             = Coord(),
    @SerializedName("weather"    ) var weather    : ArrayList<Weather> = arrayListOf(),
    @SerializedName("base"       ) var base       : String?            = null,
    @SerializedName("main"       ) var main       : Main?              = Main(),
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("wind"       ) var wind       : Wind?              = Wind(),
    @SerializedName("rain"       ) var rain       : Rain?              = Rain(),
    @SerializedName("clouds"     ) var clouds     : Clouds?            = Clouds(),
    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("sys"        ) var sys        : Sys?               = Sys(),
    @SerializedName("timezone"   ) var timezone   : Int?               = null,
    @SerializedName("id"         ) var id         : Int?               = null,
    @SerializedName("name"       ) var name       : String?            = null,
    @SerializedName("cod"        ) var cod        : Int?               = null

)