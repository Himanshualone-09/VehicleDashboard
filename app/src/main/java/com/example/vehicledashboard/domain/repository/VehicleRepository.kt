package com.example.vehicledashboard.domain.repository

import com.example.vehicledashboard.domain.model.VehicleData
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {
    fun observeVehicleData(): Flow<VehicleData>
}