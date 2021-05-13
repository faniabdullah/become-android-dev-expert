package com.bangkit.faniabdullah_made.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "tb_movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    val movie_id: Int,
    @ColumnInfo(name = "title")
    val name: String? = null,
    @ColumnInfo(name = "overview")
    val overview: String? = null,
    @ColumnInfo(name = "poster_path")
    val poster_path: String? = null,
    @ColumnInfo(name = "release_date")
    val release_date: String? = null,
    @ColumnInfo(name = "vote_average")
    val vote_average: Double? = null,
    @ColumnInfo(name = "vote_count")
    val vote_count: Int? = null,
    @ColumnInfo(name = "bookmarked")
    var isFavorite: Boolean = false,
) : Parcelable