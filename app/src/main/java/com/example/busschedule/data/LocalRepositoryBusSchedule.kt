package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class LocalRepositoryBusSchedule(private val bsDao: BusScheduleDao) :
    RepositoryBusSchedule {

    override suspend fun delete(busSchedule: BusSchedule) = bsDao.delete(busSchedule)

    override suspend fun insert(busSchedule: BusSchedule) = bsDao.insert(busSchedule)

    override suspend fun update(busSchedule: BusSchedule) = bsDao.update(busSchedule)

    override fun getAll() = bsDao.getAll()

    override fun getByStopName(stname: String) = bsDao.getByStopName(stname)
}

class FakeRepositoryBusSchedule : RepositoryBusSchedule {
    override suspend fun delete(busSchedule: BusSchedule) {
    }

    override suspend fun insert(busSchedule: BusSchedule) {
    }

    override suspend fun update(busSchedule: BusSchedule) {
    }

    override fun getAll(): Flow<List<BusSchedule>> {
        return flowOf(
            listOf(
                BusSchedule(
                    1,
                    "Raposa",
                    0
                ),
                BusSchedule(
                    2,
                    "Jaboti",
                    137371
                )
            )
        )
    }

    override fun getByStopName(stname: String): Flow<List<BusSchedule>> {
        return flowOf(
            listOf(
                BusSchedule(
                    4,
                    "Samanbita",
                    137371
                )
            )
        )
    }
}