package com.bangkit.faniabdullah_made.core.di

import android.content.Context
import androidx.room.Room
import com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDao
import com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDatabase = Room.databaseBuilder(
        context,
        com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDatabase::class.java, "Movie.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDatabase): com.bangkit.faniabdullah_made.core.data.source.local.room.MovieDao = database.movieDao()
}