package com.kmpcourse.palette.room

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

/**
 * Author: solra
 * Date Created: 19/01/2026
 */
fun iosDatabaseBuilder() : RoomDatabase.Builder<RoomDb> {
    val dbFile = documentDirectory() + "/palette.db"
    return Room.databaseBuilder<RoomDb>(
        dbFile
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )
    return requireNotNull(documentDirectory?.path)
}