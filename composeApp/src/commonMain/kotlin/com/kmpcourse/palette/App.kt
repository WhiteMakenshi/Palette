package com.kmpcourse.palette

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kmpcourse.palette.navigation.NavManager
import com.kmpcourse.palette.views.HomeView

@Composable
@Preview
fun App() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = Color.LightGray
        )
    ) {
        NavManager()
    }
}