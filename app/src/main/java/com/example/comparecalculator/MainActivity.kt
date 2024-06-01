package com.example.comparecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comparecalculator.view.CalculatorButtons
import com.example.comparecalculator.view.ResultDisplay
import com.example.comparecalculator.ui.theme.CompareCalculatorTheme
import com.example.comparecalculator.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompareCalculatorTheme {
                CompositionLocalProvider(androidx.lifecycle.compose.LocalLifecycleOwner provides androidx.compose.ui.platform.LocalLifecycleOwner.current) {
                    App()
                }
            }
        }
    }

    @Composable
    fun App() {
        Box(Modifier.fillMaxSize()) {
            ResultDisplay(
                modifier = Modifier
                    .padding(top = 56.dp, start = 8.dp, end = 8.dp)
                    .align(Alignment.TopStart),
                viewModel = viewModel
            )
            CalculatorButtons(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(Alignment.BottomStart),
                viewModel = viewModel
            )
        }
    }

    @Preview
    @Composable
    fun AppPreview() {
        CompareCalculatorTheme {
            App()
        }
    }
}