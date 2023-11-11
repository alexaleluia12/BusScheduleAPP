package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface RepositoryBusSchedule {
    suspend fun insert(busSchedule: BusSchedule)

    suspend fun update(busSchedule: BusSchedule)

    suspend fun delete(busSchedule: BusSchedule)

    fun getAll(): Flow<List<BusSchedule>>

    fun getByStopName(stname: String): Flow<List<BusSchedule>>
}