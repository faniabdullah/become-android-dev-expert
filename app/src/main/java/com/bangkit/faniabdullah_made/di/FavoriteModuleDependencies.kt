package com.bangkit.faniabdullah_made.di

import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@EntryPoint

@InstallIn(ApplicationComponent::class)
interface FavoriteModuleDependencies {

    fun movieUseCase(): MovieUseCase
}