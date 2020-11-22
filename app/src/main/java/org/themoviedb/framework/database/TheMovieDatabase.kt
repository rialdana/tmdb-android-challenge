package org.themoviedb.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.themoviedb.database.MovieDao
import org.themoviedb.database.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TheMovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: TheMovieDatabase? = null

        fun getDatabase(context: Context): TheMovieDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TheMovieDatabase::class.java,
                    "tmdb.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}