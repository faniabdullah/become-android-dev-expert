package com.bangkit.faniabdullah_made.di

import com.bangkit.faniabdullah_made.core.domain.usecase.MovieInteractor
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMovieRepository(movieInteractor: MovieInteractor): MovieUseCase
}