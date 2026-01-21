package com.kmpcourse.palette.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Author: solra
 * Date Created: 20/01/2026
 */
@Composable
fun IconTitle(title: String, icon: ImageVector) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(imageVector =  icon, title, tint = Color.White)
        Text(text = title, color = Color.White)
    }
}