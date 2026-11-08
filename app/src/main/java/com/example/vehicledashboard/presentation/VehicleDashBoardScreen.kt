package com.example.vehicledashboard.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.vehicledashboard.presentation.composables.ModeCard
import com.example.vehicledashboard.presentation.composables.Speedometer
import com.example.vehicledashboard.presentation.composables.StatusPill

@Composable
fun VehicleDashBoardScreen(viewModel: VehicleDataViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(16.dp)
    ) {


        ModeCard(modifier = Modifier.align(Alignment.TopCenter))

        uiState.situation?.let { situation ->
            StatusPill(
                label = "STATE",
                value = situation,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Speedometer(speed = formatSpeed(uiState))
            uiState.errMessage?.let { message ->
                Text(text = message, color = Color.Red, style = TextStyle(fontSize = 14.sp), modifier = Modifier.padding(top = 16.dp))
            }

        }

        StatusPill(
            label = "KILL SWITCH",
            value = killSwitchText(uiState.killSwitchActive),
            color = killSwitchColor(uiState.killSwitchActive),
            modifier = Modifier.align(Alignment.CenterEnd)
        )

        Row(
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Row() {
                Text(text = "ODO ", color = Color.LightGray, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium))
                Text(text = "1324 km", color = Color.White, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium))
            }

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End
            ) {
                StatusPill(label = "BATTERY", value = "100%", color = Color.Green)
                Spacer(modifier = Modifier.width(16.dp))
                StatusPill(label = "MOTOR STATUS", value = motorText(uiState.motorOn), color = motorColor(uiState.motorOn))
            }
        }

    }
}

private fun killSwitchText(active: Boolean?): String {
    return when(active) {
        true -> "ACTIVE"
        false -> "INACTIVE"
        null -> "--"
    }
}

private fun killSwitchColor(active: Boolean?): Color {
    return when(active) {
        true -> Color.Red
        false -> Color.Green
        null -> Color.LightGray
    }
}

private fun motorText(active: Boolean?): String {
    return when(active) {
        true -> "ON"
        false -> "OFF"
        null -> "--"
    }
}

private fun motorColor(active: Boolean?): Color {
    return when(active) {
        true -> Color.Green
        false -> Color.Gray
        null -> Color.LightGray
    }
}

private fun formatSpeed(uiState: VehicleUiState) : String {
    return if(uiState.isDataAvailable) {
        uiState.speed?.toString() ?: "--"
    } else {
        "--"
    }
}