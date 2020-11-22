package org.themoviedb.framework.di

import org.koin.dsl.module
import org.themoviedb.framework.database.TheMovieDatabase

val databaseModule = module {
    single { TheMovieDatabase.getDatabase(get()).movieDao() }
}