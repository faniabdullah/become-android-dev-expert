package com.bangkit.faniabdullah_made.di

import com.bangkit.faniabdullah_made.core.domain.usecase.MovieInteractor
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieRepository (movieInteractor: MovieInteractor ): MovieUseCase
}