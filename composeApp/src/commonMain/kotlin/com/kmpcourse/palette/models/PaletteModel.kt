package com.kmpcourse.palette.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author: solra
 * Date Created: 19/01/2026
 */
@Entity(tableName = "palettes")
data class PaletteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val desc: String
)
