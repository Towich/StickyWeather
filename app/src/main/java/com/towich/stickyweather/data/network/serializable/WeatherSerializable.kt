package com.towich.stickyweather.data.network.serializable

import kotlinx.serialization.Serializable

@Serializable
data class WeatherSerializable(
    val temp: Float
)
