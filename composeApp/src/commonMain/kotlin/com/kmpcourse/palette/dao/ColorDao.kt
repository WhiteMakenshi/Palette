package com.kmpcourse.palette.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.Query
import com.kmpcourse.palette.models.ColorModel
import kotlinx.coroutines.flow.Flow

/**
 * Author: solra
 * Date Created: 20/01/2026
 */
@Dao
interface ColorDao {
    @Insert
    suspend fun insertColor(colorItem: ColorModel)

    @Update
    suspend fun updateColor(colorItem: ColorModel)

    @Delete
    suspend fun deleteColor(colorItem: ColorModel)

    @Query("DELETE FROM colors WHERE idPalette = :idPalette")
    suspend fun deleteById(idPalette: Int)

    @Query("SELECT * FROM colors WHERE idPalette = :idPalette")
    fun getColors(idPalette: Int): Flow<List<ColorModel>>

}