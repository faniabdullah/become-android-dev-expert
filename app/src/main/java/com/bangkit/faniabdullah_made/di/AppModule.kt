package com.bangkit.faniabdullah_made.di

import com.bangkit.faniabdullah_made.core.domain.usecase.MovieInteractor
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.hilt.android.scopes.ViewModelScoped

abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTourismUseCase(tourismInteractor: MovieInteractor): MovieUseCase
}