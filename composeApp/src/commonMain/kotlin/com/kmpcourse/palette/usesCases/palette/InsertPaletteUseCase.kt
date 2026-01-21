package com.kmpcourse.palette.usesCases.palette

import com.kmpcourse.palette.models.PaletteModel
import com.kmpcourse.palette.repositories.PaletteRepository

/**
 * Author: solra
 * Date Created: 19/01/2026 
 */
class InsertPaletteUseCase(private val paletteRepository: PaletteRepository) {
    suspend operator fun invoke(paletteItem: PaletteModel) {
        paletteRepository.insertPalette(paletteItem)
    }
}