package com.towich.stickyweather.ui.screen.weather

sealed interface WeatherScreenUiState {
    data object Initial : WeatherScreenUiState
    data object Loading : WeatherScreenUiState
    data class Success<out T>(val data: T) : WeatherScreenUiState
    data class Error(val message: String) : WeatherScreenUiState
}