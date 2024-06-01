package com.example.comparecalculator.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {
    private val _selectedIndexOfTextNumberDisplay = MutableStateFlow(1)
    val selectedIndexOfTextNumberDisplay: StateFlow<Int> = _selectedIndexOfTextNumberDisplay
    private val _textNumberDisplayPrice1 = MutableStateFlow("")
    val textNumberDisplayPrice1: StateFlow<String> = _textNumberDisplayPrice1
    private val _textNumberDisplayAmount1 = MutableStateFlow("")
    val textNumberDisplayAmount1: StateFlow<String> = _textNumberDisplayAmount1
    val textNumberDisplayResult1: StateFlow<String> =
        combine(_textNumberDisplayPrice1, _textNumberDisplayAmount1) { s1, s2 ->
            divideFromStringAsString(s1, s2)
        }.stateIn(CoroutineScope(Dispatchers.Main), SharingStarted.Eagerly, "")
    private val _textNumberDisplayPrice2 = MutableStateFlow("")
    val textNumberDisplayPrice2: StateFlow<String> = _textNumberDisplayPrice2
    private val _textNumberDisplayAmount2 = MutableStateFlow("")
    val textNumberDisplayAmount2: StateFlow<String> = _textNumberDisplayAmount2
    val textNumberDisplayResult2 =
        combine(_textNumberDisplayPrice2, _textNumberDisplayAmount2) { s1, s2 ->
            divideFromStringAsString(s1, s2)
        }.stateIn(CoroutineScope(Dispatchers.Main), SharingStarted.Eagerly, "")
    val isGoodDeal1: StateFlow<Boolean> =
        combine(textNumberDisplayResult1, textNumberDisplayResult2) { r1, r2 ->
            compareResults(r1, r2)
        }.stateIn(CoroutineScope(Dispatchers.Main), SharingStarted.Eagerly, false)
    val isGoodDeal2: StateFlow<Boolean> =
        combine(textNumberDisplayResult2, textNumberDisplayResult1) { r1, r2 ->
            compareResults(r1, r2)
        }.stateIn(CoroutineScope(Dispatchers.Main), SharingStarted.Eagerly, false)

    private fun divideFromStringAsString(
        numeratorString: String,
        denominatorString: String
    ): String {
        return if (numeratorString == "" || denominatorString == "") {
            ""
        } else {
            val numerator = numeratorString.toDouble()
            val denominator = denominatorString.toDouble()
            if (numerator != 0.0 && denominator != 0.0) {
                val result = numerator / denominator
                result.toString()
            } else {
                ""
            }
        }
    }

    private fun compareResults(resultString1: String, resultString2: String): Boolean =
        if (resultString1 == "" || resultString2 == "") {
            false
        } else {
            val result1 = resultString1.toDouble()
            val result2 = resultString2.toDouble()
            result1 <= result2
        }

    fun onNextNumberDisplay() {
        if (_selectedIndexOfTextNumberDisplay.value < 4) {
            _selectedIndexOfTextNumberDisplay.value++
        } else {
            _selectedIndexOfTextNumberDisplay.value = 1
        }
    }

    fun setSelectedIndexOfTextNumberDisplay(index: Int) {
        if (index in 1..4) _selectedIndexOfTextNumberDisplay.value =
            index else throw IndexOutOfBoundsException("The index must be between 1 and 4, inclusive.")
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

    fun onClearSelectedTextNumberDisplay() {
        getSelectedNumberFlow().value = ""
    }

    fun onClearAll1() {
        _textNumberDisplayPrice1.value = ""
        _textNumberDisplayAmount1.value = ""
    }

    fun onClearAll2() {
        _textNumberDisplayPrice2.value = ""
        _textNumberDisplayAmount2.value = ""
    }
}