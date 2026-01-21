package com.kmpcourse.palette.usesCases.palette

import com.kmpcourse.palette.models.PaletteModel
import com.kmpcourse.palette.repositories.PaletteRepository
import kotlinx.coroutines.flow.Flow

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
class GetPaletteUseCase(private val paletteRepository: PaletteRepository) {
    operator fun invoke() : Flow<List<PaletteModel>?> {
        return paletteRepository.getAllPalettes()
    }
}