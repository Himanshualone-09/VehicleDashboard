package com.example.vehicledashboard.di

import com.example.vehicledashboard.data.repository.VehicleRepositoryImpl
import com.example.vehicledashboard.domain.repository.VehicleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindVehicleRepository(
        repository: VehicleRepositoryImpl
    ): VehicleRepository
}