package com.towich.stickyweather.data.network

import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.network.serializable.CitySerializable
import com.towich.stickyweather.util.ApiResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

    override suspend fun getCities(): ApiResult<List<CitySerializable>> {
        return try {
            val response = client.get(ApiRoutes.BASE_URL_CITIES)

            when(response.status.value){
                in 200..299 -> {
                    ApiResult.Success(response.body())
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }
        } catch (e: Exception) {
            ApiResult.Error("${e.message}")
        }
    }

    override suspend fun getWeatherByCity(cityModel: CityModel): ApiResult<Float> {
        return try {
            val response = client.get(ApiRoutes.BASE_URL_WEATHER + ApiRoutes.WEATHER_v2_5) {
                url {
                    parameters.append("lat", cityModel.latitude)
                    parameters.append("lon", cityModel.longitude)
                    parameters.append("appid", "1ba9f9a3308dc36189f4e308b31691a4")
                }
            }

            when(response.status.value){
                in 200..299 -> {
                    ApiResult.Success(response.body())
                }

                else -> {
                    ApiResult.Error("Code ${response.status.value}: ${response.status.description}")
                }
            }
        } catch (e: Exception) {
            ApiResult.Error("${e.message}")
        }
    }
}