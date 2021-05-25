package com.bangkit.faniabdullah_made.favorite.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.faniabdullah_made.core.domain.usecase.MovieUseCase
import com.bangkit.faniabdullah_made.favorite.ui.FavoriteViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(movieUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}