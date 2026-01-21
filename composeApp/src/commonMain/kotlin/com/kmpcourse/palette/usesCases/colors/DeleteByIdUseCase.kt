package com.kmpcourse.palette.usesCases.colors

import com.kmpcourse.palette.repositories.ColorRepository

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
class DeleteByIdUseCase(private val colorRepository: ColorRepository) {
    suspend operator fun invoke(idPalette: Int) {
        colorRepository.deleteById(idPalette)
    }
}
