package com.kmpcourse.palette.viewModels

import androidx.lifecycle.ViewModel
import com.kmpcourse.palette.copyToClipboard
import com.kmpcourse.palette.models.ColorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

/**
 * Author: solra
 * Date Created: 17/01/2026 
 */
class ColorViewModel : ViewModel() {
    private val _colors = MutableStateFlow<List<ColorModel>>(emptyList())
    val colors: StateFlow<List<ColorModel>> = _colors

    private var id = 1

    fun generateColor() {
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)

        val hex = ColorModel.rgbToHex(r,g,b)
        val newColor = ColorModel(
            id++,
            r,
            g,
            b,
            hex
        )
        _colors.value += newColor
    }

    fun removeColorById(id: Int) {
        _colors.value = _colors.value.filter { it.id != id}
    }

    fun editColor(id: Int, red: Int, green: Int, blue: Int) {
        val hex = ColorModel.rgbToHex(red, green, blue)

        _colors.value = _colors.value.map { color ->
            if (color.id == id) {
                color.copy(id = id, red = red, green = green, blue = blue, hex = hex)
            } else {
                color
            }
        }
    }

    fun reset () {
        _colors.value = emptyList()
    }

    fun copyAll() {
        val hexString = _colors.value.joinToString(separator = "\n") { it.hex }
        copyToClipboard(hexString)
    }
}