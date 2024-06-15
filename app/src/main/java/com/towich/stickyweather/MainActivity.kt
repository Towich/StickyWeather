package com.towich.stickyweather

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.towich.stickyweather.navigation.Navigation
import com.towich.stickyweather.ui.theme.StickyWeatherTheme
import com.towich.stickyweather.ui.theme.WhiteFE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(WhiteFE.toArgb(), Color.TRANSPARENT))
        setContent {
            val navController = rememberNavController()
            StickyWeatherTheme {
                Box(modifier = Modifier.fillMaxSize().statusBarsPadding()) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}