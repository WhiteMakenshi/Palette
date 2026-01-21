package com.kmpcourse.palette.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026
 * Description: [Purpose of the file]
 */
fun androidDatabaseBuilder(context: Context) : RoomDatabase.Builder<RoomDb> {
    val dbFile = context.applicationContext.getDatabasePath("palette.db")
    return Room.databaseBuilder(
        context,
        dbFile.absolutePath
    )
}
