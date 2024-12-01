package com.olpl.core_ui.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import org.koin.core.annotation.Single

@Single
fun provideCoroutineScope(
    job: Job,
    dispatcher: CoroutineDispatcher
): CoroutineScope {
    return CoroutineScope(job + dispatcher)
}

@Single
fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

@Single
fun provideJob(): Job = SupervisorJob()