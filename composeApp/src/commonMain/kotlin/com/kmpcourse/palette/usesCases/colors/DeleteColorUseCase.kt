package com.kmpcourse.palette.usesCases.colors

import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.repositories.ColorRepository

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
class DeleteColorUseCase(private val colorRepository: ColorRepository) {
    suspend operator fun invoke(colorItem: ColorModel) {
        colorRepository.deleteColor(colorItem)
    }
}