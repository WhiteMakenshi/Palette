package com.kmpcourse.palette

import android.app.Application
import com.kmpcourse.palette.di.AndroidDatabaseModule
import com.kmpcourse.palette.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026 
 * Description: [Purpose of the file]
 */
 class PaletteApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PaletteApplication)
            modules(AndroidDatabaseModule, sharedModule)
        }
    }
}