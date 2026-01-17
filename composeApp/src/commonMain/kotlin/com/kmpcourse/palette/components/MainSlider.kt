package com.kmpcourse.palette.components

import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Author: solra
 * Date Created: 17/01/2026
 */
@Composable
fun MainSlider(value: Float, color: Color, onValueChange: (Float) -> Unit) {
    Slider(
        value,
        onValueChange,
        valueRange = 0f..255f,
        colors = SliderDefaults.colors(
            thumbColor = color,
            activeTrackColor = color,
            inactiveTickColor = Color.LightGray
        )
    )
}