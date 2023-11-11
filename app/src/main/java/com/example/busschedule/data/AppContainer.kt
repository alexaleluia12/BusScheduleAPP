package com.example.busschedule.data

import android.content.Context

interface AppContainer {
    val repositoryBusSchedule: RepositoryBusSchedule
}

class AppDataContainer(private val context: Context): AppContainer {
    override val repositoryBusSchedule: RepositoryBusSchedule by lazy {
        LocalRepositoryBusSchedule(
            ScheduleDatabase.getDatabase(context).busScheduleDao()
        )
    }
}