package com.kmpcourse.palette.navigation

import kotlinx.serialization.Serializable

/**
 * Author: solra
 * Date Created: 20/01/2026
 */
@Serializable
object Home

@Serializable
data class Palette(val id: Int, val name: String)

@Serializable
data class DetailColor(val id: Int, val name: String)
