package com.kmpcourse.palette.room

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026 
 * Description: [Purpose of the file]
 */
class CreateDatabase(private val builder: RoomDatabase.Builder<RoomDb>) {
    fun getDatabase(): RoomDb {
        return builder
            .fallbackToDestructiveMigration(dropAllTables = true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}