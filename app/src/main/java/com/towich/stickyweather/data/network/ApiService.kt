package com.towich.stickyweather.data.network

import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.network.serializable.CitySerializable
import com.towich.stickyweather.data.network.serializable.WeatherSerializable
import com.towich.stickyweather.util.ApiResult

interface ApiService {
    suspend fun getCities(): ApiResult<List<CityModel>>
    suspend fun getWeatherByCity(cityModel: CityModel): ApiResult<WeatherSerializable>
}