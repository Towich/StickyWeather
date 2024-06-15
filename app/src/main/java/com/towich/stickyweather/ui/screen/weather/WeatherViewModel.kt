package com.towich.stickyweather.ui.screen.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.repository.MainRepository
import com.towich.stickyweather.util.ApiResult
import com.towich.stickyweather.util.ScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _screenUiState = MutableStateFlow<ScreenUiState>(ScreenUiState.Initial)
    val screenUiState: StateFlow<ScreenUiState> = _screenUiState

    private val _temperature = MutableStateFlow<Int?>(null)
    val temperature: StateFlow<Int?> = _temperature

    init {
        getWeather()
    }

    fun getCurrentCity(): CityModel? {
        return repository.getCurrentCity()
    }

    fun getWeather() {
        val currentCity = repository.getCurrentCity()
        if (currentCity != null) {
            viewModelScope.launch {
                _screenUiState.value = ScreenUiState.Loading

                when (val result = repository.getWeatherByCity(cityModel = currentCity)) {
                    is ApiResult.Success -> {
                        _screenUiState.value = ScreenUiState.Success(result.data)
                        _temperature.value = result.data.main?.temp?.roundToInt()
                    }

                    is ApiResult.Error -> {
                        _screenUiState.value = ScreenUiState.Error(result.error)
                    }
                }
            }
        }
    }
}