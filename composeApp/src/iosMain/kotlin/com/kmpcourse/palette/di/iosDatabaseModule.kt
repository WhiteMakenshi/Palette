package com.kmpcourse.palette.di

import androidx.room.RoomDatabase
import com.kmpcourse.palette.room.RoomDb
import com.kmpcourse.palette.room.iosDatabaseBuilder
import org.koin.dsl.module

/**
 * Author: solra
 * Date Created: 19/01/2026
 */
val iosDatabaseModule = module {
    single <RoomDatabase.Builder<RoomDb>> { iosDatabaseBuilder() }
}