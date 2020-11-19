package org.themoviedb

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.themoviedb.framework.di.appModule
import org.themoviedb.framework.di.retrofitModule

class TheMovieDB : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@TheMovieDB)
            modules(listOf(appModule, retrofitModule))
        }
    }
}