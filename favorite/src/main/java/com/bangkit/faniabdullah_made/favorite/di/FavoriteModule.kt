package com.bangkit.faniabdullah_made.favorite.di

import android.content.Context
import com.bangkit.faniabdullah_made.di.FavoriteModuleDependencies
import com.bangkit.faniabdullah_made.favorite.FavoriteFragment
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteModule {
    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(FavoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteModule
    }
}