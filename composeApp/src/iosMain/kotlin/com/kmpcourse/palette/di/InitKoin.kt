package com.kmpcourse.palette.di

import org.koin.core.context.startKoin

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026
 * Description: [Purpose of the file]
 */
fun initKoin() {
    startKoin {
        modules(iosDatabaseModule, sharedModule)
    }
}