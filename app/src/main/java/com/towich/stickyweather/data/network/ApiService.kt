package com.towich.stickyweather.data.network

import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.network.serializable.CitySerializable
import com.towich.stickyweather.util.ApiResult

interface ApiService {
    suspend fun getCities(): ApiResult<List<CitySerializable>>
    suspend fun getWeatherByCity(cityModel: CityModel): ApiResult<Float>
}