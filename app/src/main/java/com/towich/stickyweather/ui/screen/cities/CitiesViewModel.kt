package com.towich.stickyweather.ui.screen.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.towich.stickyweather.data.model.CityModel
import com.towich.stickyweather.data.repository.MainRepository
import com.towich.stickyweather.util.ScreenUiState
import com.towich.stickyweather.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _screenUiState = MutableStateFlow<ScreenUiState>(ScreenUiState.Initial)
    val screenUiState: StateFlow<ScreenUiState> = _screenUiState

    private val _listOfCities = MutableStateFlow<List<CityModel>>(listOf(CityModel(id = "0", city = "Loading..", longitude = "31.43", latitude = "43.43")))
    val listOfCities: StateFlow<List<CityModel>> = _listOfCities

    init {
        getAllCities()
    }

    fun getAllCities(){
        viewModelScope.launch {
            _screenUiState.value = ScreenUiState.Loading

            when (val result = repository.getCities()) {
                is ApiResult.Success -> {
                    _screenUiState.value = ScreenUiState.Success(result.data)
                    _listOfCities.value = result.data.sortedBy { it.city }
                }

                is ApiResult.Error -> {
                    _screenUiState.value = ScreenUiState.Error(result.error)
                }
            }
        }
    }

    fun setCurrentCityModel(cityModel: CityModel){
        repository.setCurrentCity(cityModel = cityModel)
    }
}