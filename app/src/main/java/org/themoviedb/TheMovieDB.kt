package org.themoviedb

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.themobiedb.di.interactionModule
import org.themoviedb.di.dataModule
import org.themoviedb.framework.di.databaseModule
import org.themoviedb.framework.di.viewModelModule
import retrofitModule

class TheMovieDB : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@TheMovieDB)
            modules(listOf(retrofitModule, viewModelModule, dataModule, interactionModule, databaseModule))
        }
    }
}