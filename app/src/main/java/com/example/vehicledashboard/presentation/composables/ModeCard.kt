package com.example.vehicledashboard.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModeCard(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .background(color = Color.DarkGray, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "ECO",
            color = Color.Green,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "62",
            color = Color.White,
            style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = " km Range",
            color = Color.LightGray,
            style = TextStyle(fontSize = 14.sp)
        )

    }
}