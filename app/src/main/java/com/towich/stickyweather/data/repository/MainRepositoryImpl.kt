package com.towich.stickyweather.data.repository

import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.network.ApiService
import com.towich.stickyweather.data.network.serializable.WeatherSerializable
import com.towich.stickyweather.data.source.SessionStorage
import com.towich.stickyweather.util.ApiResult

class MainRepositoryImpl(
    private val apiService: ApiService,
    private val sessionStorage: SessionStorage
): MainRepository {

    override suspend fun getCities(): ApiResult<List<CityModel>> {
        return apiService.getCities()
    }

    override suspend fun getWeatherByCity(cityModel: CityModel): ApiResult<WeatherSerializable> {
        return apiService.getWeatherByCity(cityModel = cityModel)
    }

    override fun getCurrentCity(): CityModel? {
        return sessionStorage.currentCityModel
    }

    override fun setCurrentCity(cityModel: CityModel) {
        sessionStorage.currentCityModel = cityModel
    }

}