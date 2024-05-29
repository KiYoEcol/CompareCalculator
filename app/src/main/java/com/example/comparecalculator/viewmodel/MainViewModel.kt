package com.example.comparecalculator.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _textNumberDisplayPrice1 = MutableStateFlow("")
    val textNumberDisplayPrice1: StateFlow<String> = _textNumberDisplayPrice1

    fun onDigit(digit: String) {
        val displayNumber = displayNumberPolicy(digit)
        _textNumberDisplayPrice1.value = displayNumber
    }

    private fun displayNumberPolicy(digit: String): String {
        var displayNumber: String
        when {
            digit == "." && textNumberDisplayPrice1.value == "" -> displayNumber = ""
            textNumberDisplayPrice1.value == "" || (textNumberDisplayPrice1.value == "0" && digit != ".") -> displayNumber =
                digit

            digit == "." && textNumberDisplayPrice1.value.contains(".") -> displayNumber =
                textNumberDisplayPrice1.value

            else -> {
                displayNumber = _textNumberDisplayPrice1.value
                displayNumber += digit
            }
        }
        return displayNumber
    }

    fun onClear() {
        _textNumberDisplayPrice1.value = ""
    }
}