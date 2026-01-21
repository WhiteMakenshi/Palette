package com.kmpcourse.palette.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.kmpcourse.palette.dao.ColorDao
import com.kmpcourse.palette.dao.PaletteDao
import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.models.PaletteModel

/**
 * Author: solra
 * Date Created: 19/01/2026 
 */
@Database(
    entities = [
        PaletteModel::class,
        ColorModel::class
    ],
    version = 2, exportSchema = true)
@ConstructedBy(AppDataBaseConstructor::class)
abstract class RoomDb : RoomDatabase() {
    abstract fun paletteDao(): PaletteDao
    abstract fun colorDao(): ColorDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDataBaseConstructor: RoomDatabaseConstructor<RoomDb> {
    override fun initialize(): RoomDb
}