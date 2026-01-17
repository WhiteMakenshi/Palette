package com.kmpcourse.palette.models

/**
 * Author: solra
 * Date Created: 17/01/2026
 */
data class ColorModel(
    val id: Int,
    val red: Int,
    val green: Int,
    val blue: Int,
    val hex: String,
    var rgb: String = "RGB($red, $green, $blue)"
) {
    companion object {
        fun rgbToHex(r: Int, g: Int, b: Int): String {
            val red = r.toString(16).padStart(2, '0')
            val green = g.toString(16).padStart(2, '0')
            val blue = b.toString(16).padStart(2, '0')
            return "#$red$green$blue".uppercase()
        }
    }
}
