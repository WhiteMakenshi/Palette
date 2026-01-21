package com.kmpcourse.palette.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmpcourse.palette.models.PaletteModel

/**
 * Author: solra
 * Date Created: 20/01/2026
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalPalette(
    palette: PaletteModel? = null,
    onDismiss: () -> Unit,
    onSave: (PaletteModel) -> Unit,
) {
    val modalState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var name by remember { mutableStateOf(palette?.name ?: "") }
    var desc by remember { mutableStateOf(palette?.desc ?: "") }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = modalState,
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(if(palette != null) "Edit Palette" else "Create Palette", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.focusRequester(focusRequester)
            )
            OutlinedTextField(
                value = desc,
                onValueChange = { desc = it },
                label = { Text("Description") },
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button({
                if (!name.isEmpty()) {
                    onSave(PaletteModel(
                        id = palette?.id ?: 0,
                        name = name,
                        desc = desc
                    ))
                    onDismiss()
                }
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)))
            {
                Text(if(palette != null) "Update" else "Save", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }

}