package com.kmpcourse.palette.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kmpcourse.palette.components.ColorCard
import com.kmpcourse.palette.components.MainSlider
import com.kmpcourse.palette.copyToClipboard
import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.viewModels.ColorViewModel
import org.jetbrains.compose.resources.painterResource
import palette.composeapp.generated.resources.Res
import palette.composeapp.generated.resources.palette

/**
 * Author: solra
 * Date Created: 14/01/2026 07:49 p.m.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: ColorViewModel = viewModel { ColorViewModel() }) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val colors by viewModel.colors.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row {
                        Image(painterResource(Res.drawable.palette),
                            "logo",
                            modifier = Modifier.height(25.dp)
                        )
                    }
                },
                actions = {
                    IconButton({ viewModel.copyAll() }) {
                        Icon(Icons.Default.CopyAll, "Copy All")
                    }
                },
                navigationIcon = {
                    IconButton({ viewModel.reset() }) {
                        Icon(Icons.Default.Restore, "Reset")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.generateColor()
            },
                containerColor = Color.Black,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, "Add")
            }
        }
    ) { paddingValues ->
        ContentHomeView(modifier = Modifier.padding(paddingValues),
            colors,
            { id, red, green, blue ->
                viewModel.editColor(id, red, green, blue)
            },
            {
                copyToClipboard(it)
            },
            {
                viewModel.removeColorById(it)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(
    modifier: Modifier,
    list : List<ColorModel>,
    onEdit: (Int, Int, Int, Int) -> Unit,
    onCopy: (String) -> Unit,
    onDelete: (Int) -> Unit,
) {
    val modalState = rememberModalBottomSheetState (
        skipPartiallyExpanded = true
    )
    var showModal by remember { mutableStateOf(false) }
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }
    var id by remember { mutableStateOf(0) }

    LazyColumn(modifier) {
        items(list) { color ->
            ColorCard(
                color.hex,
                color.rgb,
                {
                    red = color.red.toFloat()
                    green = color.green.toFloat()
                    blue = color.blue.toFloat()
                    id = color.id

                    showModal = true
                },
                {
                    onCopy(color.hex)
                },
                {
                    onDelete(color.id)
                }
            )
        }
    }

    if (showModal) {
        ModalBottomSheet(
            onDismissRequest = { showModal = false },
            sheetState = modalState
        ) {
            Column(modifier = Modifier.padding(40.dp)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Edit Color", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(30.dp))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp)
                    .shadow(elevation = 12.dp)
                    .background(Color(red.toInt(), green.toInt(), blue.toInt()))
                )

                Spacer(modifier = Modifier.height(25.dp))

                MainSlider(
                    value = red,
                    onValueChange = { red = it },
                    color = Color.Red
                )
                MainSlider(
                    value = green,
                    onValueChange = { green = it },
                    color = Color.Green
                )
                MainSlider(
                    value = blue,
                    onValueChange = { blue = it },
                    color = Color.Blue
                )

                OutlinedButton({
                    onEdit(id, red.toInt(), green.toInt(), blue.toInt())
                    showModal = false
                }) {
                    Text("Change Color", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
