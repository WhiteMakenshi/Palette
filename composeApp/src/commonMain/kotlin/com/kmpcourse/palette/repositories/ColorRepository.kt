package com.kmpcourse.palette.repositories

import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.room.RoomDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

/**
 * Author: solra
 * Date Created: 20/01/2026
 */
class ColorRepository(private val database: RoomDb) {
    private val dispatchers = Dispatchers.IO

    suspend fun insertColor(colorItem: ColorModel) {
        with(dispatchers) {
            database.colorDao().insertColor(colorItem)
        }
    }

    suspend fun deleteColor(colorItem: ColorModel) {
        with(dispatchers) {
            database.colorDao().deleteColor(colorItem)
        }
    }

    suspend fun updateColor(colorItem: ColorModel) {
        with(dispatchers) {
            database.colorDao().updateColor(colorItem)
        }
    }

    suspend fun deleteById(idPalette: Int) {
        with(dispatchers) {
            database.colorDao().deleteById(idPalette)
        }
    }

    fun getColors(idPalette: Int): Flow<List<ColorModel>?> {
        return database.colorDao().getColors(idPalette)
    }
}