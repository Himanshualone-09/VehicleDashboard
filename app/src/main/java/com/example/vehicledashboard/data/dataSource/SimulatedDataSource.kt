package com.example.vehicledashboard.data.dataSource

import com.example.vehicledashboard.domain.model.VehicleData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class SimulatedDataSource @Inject constructor() {

    fun getVehicleData(): Flow<VehicleData> = flow {
        val states = listOf<VehicleData>(
            VehicleData(0, false, false, "Parked", System.currentTimeMillis()),
            VehicleData(0, true, false, "Ready", System.currentTimeMillis()),
            VehicleData(25, true, false, "Riding", System.currentTimeMillis()),
            VehicleData(50, true, false, "Accelerating", System.currentTimeMillis()),
            VehicleData(0, false, true, "Motor Disabled", System.currentTimeMillis())
        )

        while (true) {
            states.forEach { data ->
                emit(data.copy(
                    timeStamp = System.currentTimeMillis()
                ))

                delay(1.seconds)
            }
        }
    }
}