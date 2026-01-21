package com.kmpcourse.palette.usesCases.palette

import com.kmpcourse.palette.models.PaletteModel
import com.kmpcourse.palette.repositories.PaletteRepository

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026 
 * Description: [Purpose of the file]
 */
class InsertPaletteUseCase(private val paletteRepository: PaletteRepository) {
    suspend operator fun invoke(paletteItem: PaletteModel) {
        paletteRepository.insertPalette(paletteItem)
    }
}