package com.kmpcourse.palette.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kmpcourse.palette.views.DetailColorView
import com.kmpcourse.palette.views.HomeView
import com.kmpcourse.palette.views.PaletteView

/**
 * Author: solra
 * Date Created: 20/01/2026 
 */
@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeView(navController)
        }
        composable<Palette> { item ->
            val palette = item.toRoute<Palette>()
            PaletteView(navController, palette.id, palette.name)
        }
        composable<DetailColor> { item ->
            val color = item.toRoute<DetailColor>()
            DetailColorView(navController, color)
        }
    }
}