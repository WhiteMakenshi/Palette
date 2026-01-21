package com.kmpcourse.palette.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmpcourse.palette.copyToClipboard
import com.kmpcourse.palette.models.ColorModel
import com.kmpcourse.palette.usesCases.colors.DeleteByIdUseCase
import com.kmpcourse.palette.usesCases.colors.DeleteColorUseCase
import com.kmpcourse.palette.usesCases.colors.GetColorsUseCase
import com.kmpcourse.palette.usesCases.colors.InsertColorUseCase
import com.kmpcourse.palette.usesCases.colors.UpdateColorUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * Author: solra
 * Date Created: 17/01/2026 
 */
class ColorViewModel(
    private val insertColorUseCase: InsertColorUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val updateColorUseCase: UpdateColorUseCase,
    private val deleteColorUseCase: DeleteColorUseCase,
    private val deleteByIdUseCase: DeleteByIdUseCase
) : ViewModel() {
    private val _colors = MutableStateFlow<List<ColorModel>>(emptyList())
    val colors: StateFlow<List<ColorModel>> = _colors

    fun insertColor(idPalette: Int) {
        viewModelScope.launch {
            insertColorUseCase(idPalette)
        }
    }

    fun getColors(idPalette: Int): Flow<List<ColorModel>?> {
        return getColorsUseCase(idPalette)
    }

    fun editColor(colorItem: ColorModel, red: Int, green: Int, blue: Int) {
        viewModelScope.launch {
            updateColorUseCase(colorItem, red, green, blue)
        }
    }

    fun deleteColor(colorItem: ColorModel) {
        viewModelScope.launch {
            deleteColorUseCase(colorItem)
        }
    }

    fun deleteColorById(idPalette: Int) {
        viewModelScope.launch {
            deleteByIdUseCase(idPalette)
        }
    }

    private fun getColorsCopy(idPalette: Int) {
        viewModelScope.launch {
            getColorsUseCase(idPalette).collect { list ->
                _colors.value = list ?: emptyList()
            }
        }
    }

    fun copyAll(idPalette: Int) {
        getColorsCopy(idPalette)
        val hexString = _colors.value.joinToString(separator = "\n") { it.hex }
        copyToClipboard(hexString)
    }
}
