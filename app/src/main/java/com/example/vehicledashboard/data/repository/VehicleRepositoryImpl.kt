package com.example.vehicledashboard.data.repository

import com.example.vehicledashboard.data.dataSource.SimulatedDataSource
import com.example.vehicledashboard.domain.model.VehicleData
import com.example.vehicledashboard.domain.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(
    private val source: SimulatedDataSource
): VehicleRepository {
    override fun observeVehicleData(): Flow<VehicleData> {
        return source.getVehicleData()
    }

}