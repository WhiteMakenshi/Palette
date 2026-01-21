package com.kmpcourse.palette.usesCases.palette

import com.kmpcourse.palette.models.PaletteModel
import com.kmpcourse.palette.repositories.ColorRepository
import com.kmpcourse.palette.repositories.PaletteRepository

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
class DeletePaletteUseCase(
    private val paletteRepository: PaletteRepository,
    private val colorRepository: ColorRepository
) {
    suspend operator fun invoke(paletteItem: PaletteModel) {
        colorRepository.deleteById(paletteItem.id)
        paletteRepository.deletePalette(paletteItem)
    }
}