package com.kmpcourse.palette.repositories

import com.kmpcourse.palette.models.PaletteModel
import com.kmpcourse.palette.room.RoomDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026 
 * Description: [Purpose of the file]
 */
class PaletteRepository(private val database: RoomDb) {
    private val dispatchers = Dispatchers.IO

    suspend fun insertPalette(paletteItem: PaletteModel) {
        with(dispatchers) {
            database.paletteDao().insert(paletteItem)
        }
    }

    suspend fun updatePalette(paletteItem: PaletteModel) {
        with(dispatchers) {
            database.paletteDao().update(paletteItem)
        }
    }

    suspend fun deletePalette(paletteItem: PaletteModel) {
        with(dispatchers) {
            database.paletteDao().delete(paletteItem)
        }
    }

    fun getAllPalettes() : Flow<List<PaletteModel>?> {
        return database.paletteDao().getAll()
    }
}