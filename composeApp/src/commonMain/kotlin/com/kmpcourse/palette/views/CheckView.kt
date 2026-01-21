package com.kmpcourse.palette.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmpcourse.palette.models.PaletteModel
import com.kmpcourse.palette.viewModels.PaletteViewModel
import org.koin.compose.viewmodel.koinViewModel

/**
 * Author: solra
 * Date Created: 20/01/2026
 */
@Composable
fun CheckView(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<PaletteViewModel>()
    val palettes by viewModel.getPalettes().collectAsState(null)
    Column(
        modifier = modifier.padding(top=50.dp)
    ) {
        Text("Test")
        Button({
            val x = PaletteModel(name = "Paleta 1", desc = "Descripción de la paleta 1")
            viewModel.insertPalette(x)
        }) {
            Text("Save")
        }
        LazyColumn {
            items(palettes.orEmpty()) { item ->
                Text(item.name)
                Text(item.desc)
            }
        }
    }
}