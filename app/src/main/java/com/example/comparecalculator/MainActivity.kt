package com.example.comparecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comparecalculator.ui.component.CalculatorButtons
import com.example.comparecalculator.ui.component.ResultDisplay
import com.example.comparecalculator.ui.theme.CompareCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompareCalculatorTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Spacer(modifier = Modifier.height(56.dp))
        ResultDisplay()
        Spacer(modifier = Modifier.height(12.dp))
        CalculatorButtons()
    }
}

@Preview
@Composable
fun AppPreview() {
    CompareCalculatorTheme {
        App()
    }
}