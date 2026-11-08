package com.example.vehicledashboard.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Speedometer(
    speed: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = speed, color = Color.White, style = TextStyle(fontSize = 120.sp, fontWeight = FontWeight.Bold))
        Text(text = "Km/h", color = Color.Gray, style = TextStyle(fontSize = 16.sp), letterSpacing = 4.sp)
    }

}