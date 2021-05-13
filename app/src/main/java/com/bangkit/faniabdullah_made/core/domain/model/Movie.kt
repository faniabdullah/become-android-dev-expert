package com.bangkit.faniabdullah_made.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie (
    val id : Int,
    val name : String ,
    val overview : String? = null,
    val poster : String ? = null,
    val isFavorite: Boolean,
    val vote_average: Double? = null,
) : Parcelable