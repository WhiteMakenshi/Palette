package com.kmpcourse.palette.usesCases.colors

import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.repositories.ColorRepository

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
class UpdateColorUseCase(private val colorRepository: ColorRepository) {
    suspend operator fun invoke(colorItem: ColorModel, red: Int, green: Int, blue: Int) {
        val hex = ColorModel.rgbToHex(red, green, blue)
        val rgb = "RGB($red, $green, $blue)"

        val updateColor = colorItem.copy(
            red = red,
            green = green,
            blue = blue,
            hex = hex,
            rgb = rgb
        )
        colorRepository.updateColor(updateColor)
    }
}
