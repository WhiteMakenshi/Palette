package com.kmpcourse.palette.usesCases.colors

import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.repositories.ColorRepository
import kotlinx.coroutines.flow.Flow

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
class GetColorsUseCase(private val colorRepository: ColorRepository) {
    operator fun invoke (idPalette: Int) : Flow<List<ColorModel>?> {
        return colorRepository.getColors(idPalette)
    }
}