package com.example.vehicledashboard.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
fun StatusPill(
    label: String,
    value: String,
    color: Color,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .background(color = Color.DarkGray, RoundedCornerShape(48.dp))
            .border(1.dp, color.copy(alpha = 0.5f), RoundedCornerShape(48.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(10.dp).background(color, CircleShape))
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = label, color = Color.LightGray, style = TextStyle(fontSize = 16.sp))
            Text(text = value, color = color, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
        }
    }

}