package com.kmpcourse.palette.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kmpcourse.palette.models.PaletteModel
import kotlinx.coroutines.flow.Flow

/**
 * Title: PaletteDao.kt
 * Author: solra
 * Date Created: 19/01/2026
 * Description: [Purpose of the file]
 */
@Dao
interface PaletteDao {
    @Insert
    suspend fun insert(paletteItem: PaletteModel)

    @Update
    suspend fun update(paletteItem: PaletteModel)

    @Delete
    suspend fun delete(paletteItem: PaletteModel)

    @Query("SELECT * FROM palettes")
    fun getAll(): Flow<List<PaletteModel>>
}