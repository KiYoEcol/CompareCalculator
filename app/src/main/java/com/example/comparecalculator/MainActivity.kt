package com.example.comparecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comparecalculator.ui.view.CalculatorButtons
import com.example.comparecalculator.ui.view.ResultDisplay
import com.example.comparecalculator.ui.theme.CompareCalculatorTheme
import com.example.comparecalculator.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Spacer(modifier = Modifier.height(56.dp))
            ResultDisplay(viewModel = viewModel)
            Spacer(modifier = Modifier.height(12.dp))
            CalculatorButtons(viewModel = viewModel)
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