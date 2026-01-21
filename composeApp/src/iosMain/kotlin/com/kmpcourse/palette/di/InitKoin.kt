package com.kmpcourse.palette.di

import org.koin.core.context.startKoin

/**
 * Author: solra
 * Date Created: 19/01/2026
 */
fun initKoin() {
    startKoin {
        modules(iosDatabaseModule, sharedModule)
    }
}