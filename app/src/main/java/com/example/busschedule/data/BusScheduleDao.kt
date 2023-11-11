package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {
    @Insert
    suspend fun insert(busSchedule: BusSchedule)

    @Update
    suspend fun update(busSchedule: BusSchedule)

    @Delete
    suspend fun delete(busSchedule: BusSchedule)

    @Query("SELECT * FROM Schedule ORDER BY arrival_time DESC")
    fun getAll(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM Schedule WHERE stop_name = :stname ORDER BY arrival_time DESC LIMIT 1")
    fun getByStopName(stname: String): Flow<BusSchedule>
}