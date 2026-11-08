package com.example.vehicledashboard

import com.example.vehicledashboard.domain.model.VehicleData
import com.example.vehicledashboard.domain.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeVehicleRepository(
    private val vehicleData: VehicleData? = null,
    private val shouldThrowError: Boolean = false
): VehicleRepository {

    override fun observeVehicleData(): Flow<VehicleData> = flow{

        if(shouldThrowError) {
            throw RuntimeException("Repo Failure")
        }

        vehicleData?.let {
            emit(it)
        }

    }
}