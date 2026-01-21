package com.kmpcourse.palette.di

import androidx.room.RoomDatabase
import com.kmpcourse.palette.room.RoomDb
import com.kmpcourse.palette.room.androidDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Author: solra
 * Date Created: 19/01/2026
 */
val AndroidDatabaseModule = module {
    single <RoomDatabase.Builder<RoomDb>> { androidDatabaseBuilder(androidContext()) }
}