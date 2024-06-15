package com.towich.stickyweather.ui.screen.weather

import androidx.lifecycle.ViewModel
import com.towich.stickyweather.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {


}