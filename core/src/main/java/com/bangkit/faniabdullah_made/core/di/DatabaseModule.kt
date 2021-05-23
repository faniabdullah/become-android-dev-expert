package com.bangkit.faniabdullah_made.core.di

import android.content.Context
import androidx.room.Room
import com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDao
import com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("faniabdullah".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "Movie.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}