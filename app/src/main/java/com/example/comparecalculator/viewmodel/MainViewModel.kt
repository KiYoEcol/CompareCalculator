package com.example.comparecalculator.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _selectedIndexOfTextNumberDisplay = MutableStateFlow(1)
    val selectedIndexOfTextNumberDisplay: StateFlow<Int> = _selectedIndexOfTextNumberDisplay
    private val _textNumberDisplayPrice1 = MutableStateFlow("")
    val textNumberDisplayPrice1: StateFlow<String> = _textNumberDisplayPrice1
    private val _textNumberDisplayAmount1 = MutableStateFlow("")
    val textNumberDisplayAmount1: StateFlow<String> = _textNumberDisplayAmount1
    private val _textNumberDisplayPrice2 = MutableStateFlow("")
    val textNumberDisplayPrice2: StateFlow<String> = _textNumberDisplayPrice2
    private val _textNumberDisplayAmount2 = MutableStateFlow("")
    val textNumberDisplayAmount2: StateFlow<String> = _textNumberDisplayAmount2

    fun onNextNumberDisplay() {
        if (_selectedIndexOfTextNumberDisplay.value < 4) {
            _selectedIndexOfTextNumberDisplay.value++
        } else {
            _selectedIndexOfTextNumberDisplay.value = 1
        }
    }

    private fun getSelectedNumberFlow(): MutableStateFlow<String> =
        when (_selectedIndexOfTextNumberDisplay.value) {
            1 -> _textNumberDisplayPrice1
            2 -> _textNumberDisplayAmount1
            3 -> _textNumberDisplayPrice2
            else -> _textNumberDisplayAmount2
        }

    fun onDigit(digit: String) {
        val numberFlow = getSelectedNumberFlow()
        val displayNumber = displayNumberPolicy(digit, numberFlow)
        numberFlow.value = displayNumber
    }

    private fun displayNumberPolicy(digit: String, numberFlow: MutableStateFlow<String>): String {
        var displayNumber: String
        when {
            digit == "." && numberFlow.value == "" -> displayNumber = ""
            numberFlow.value == "" || (numberFlow.value == "0" && digit != ".") -> displayNumber =
                digit

            digit == "." && numberFlow.value.contains(".") -> displayNumber =
                numberFlow.value

            else -> {
                displayNumber = numberFlow.value
                displayNumber += digit
            }
        }
        return displayNumber
    }

    fun onClear() {
        getSelectedNumberFlow().value = ""
    }
}