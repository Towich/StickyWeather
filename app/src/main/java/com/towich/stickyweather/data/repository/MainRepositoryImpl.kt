package com.towich.stickyweather.data.repository

import android.util.Log
import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.network.ApiService
import com.towich.stickyweather.data.source.SessionStorage
import com.towich.stickyweather.ui.screen.weather.WeatherScreenUiState
import com.towich.stickyweather.util.ApiResult
import kotlinx.coroutines.runBlocking

class MainRepositoryImpl(
    private val apiService: ApiService,
    private val sessionStorage: SessionStorage
): MainRepository {

    override suspend fun getCities(): ApiResult<List<CityModel>> {
        return apiService.getCities()
    }

    override suspend fun getWeatherByCity(cityModel: CityModel): ApiResult<Float> {
        return apiService.getWeatherByCity(cityModel = cityModel)
    }

}