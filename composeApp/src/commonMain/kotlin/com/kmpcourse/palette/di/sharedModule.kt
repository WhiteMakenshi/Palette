package com.kmpcourse.palette.di

import com.kmpcourse.palette.repositories.ColorRepository
import com.kmpcourse.palette.repositories.PaletteRepository
import com.kmpcourse.palette.room.CreateDatabase
import com.kmpcourse.palette.room.RoomDb
import com.kmpcourse.palette.usesCases.colors.DeleteByIdUseCase
import com.kmpcourse.palette.usesCases.colors.DeleteColorUseCase
import com.kmpcourse.palette.usesCases.colors.GetColorsUseCase
import com.kmpcourse.palette.usesCases.colors.InsertColorUseCase
import com.kmpcourse.palette.usesCases.colors.UpdateColorUseCase
import com.kmpcourse.palette.usesCases.palette.DeletePaletteUseCase
import com.kmpcourse.palette.usesCases.palette.GetPaletteUseCase
import com.kmpcourse.palette.usesCases.palette.InsertPaletteUseCase
import com.kmpcourse.palette.usesCases.palette.UpdatePaletteUseCase
import com.kmpcourse.palette.viewModels.ColorViewModel
import com.kmpcourse.palette.viewModels.PaletteViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Title: [FileName].kt
 * Author: solra
 * Date Created: 19/01/2026
 * Description: [Purpose of the file]
 */
val sharedModule = module {
    single <RoomDb> { CreateDatabase(get()).getDatabase() }

    //Repositories
    singleOf(::PaletteRepository)
    singleOf(::ColorRepository)

    //Uses case Palette
    singleOf(::InsertPaletteUseCase)
    singleOf(::UpdatePaletteUseCase)
    singleOf(::GetPaletteUseCase)
    singleOf(::DeletePaletteUseCase)

    //Uses case Colors
    singleOf(::InsertColorUseCase)
    singleOf(::GetColorsUseCase)
    singleOf(::UpdateColorUseCase)
    singleOf(::DeleteColorUseCase)
    singleOf(::DeleteByIdUseCase)


    //viewModels
    viewModelOf(::PaletteViewModel)
    viewModelOf(::ColorViewModel)
}