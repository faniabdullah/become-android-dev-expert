package com.bangkit.faniabdullah_made.movie_detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import com.bangkit.faniabdullah_made.R
import com.bangkit.faniabdullah_made.core.domain.model.Movie
import com.bangkit.faniabdullah_made.databinding.ActivityMovieDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private val detailViewModel: MovieDetailViewModel by viewModels()

    companion object {
        const val EXTRA_DATA = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)

    }

    private fun shareSetting(name: String, overview: String?) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder.from(this).apply {
            setType(mimeType)
            setChooserTitle(name)
            setText("$name \n $overview")
            startChooser()
        }
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.name
            binding.contentDetailMovie.apply {
                tvMovieDetailTitle.text = detailMovie.name
                tvOverviewDetail.text = detailMovie.overview
                tvRatingMovie.text = detailMovie.vote_average.toString()
                tvInformationDetail.text = detailMovie.original_language
                Glide.with(this@MovieDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500${detailMovie.poster}")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.placeholder_movie)
                    .into(posterMovie)
                var statusFavorite = detailMovie.isFavorite
                setStatusFavorite(statusFavorite)

                addToFavorite.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                    setStatusFavorite(statusFavorite)
                    showSnackBar(statusFavorite, detailMovie.name)
                }

                buttonShare.setOnClickListener {
                    shareSetting(detailMovie.name , detailMovie.overview)
                }

            }

        }
    }

    private fun showSnackBar(state: Boolean, name: String) {
        val msg = if (state) {
            "$name " + getString(R.string.added_to_favorite)
        } else {
            "$name " + getString(R.string.removed_from_favorite)
        }
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG)
            .show()
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.contentDetailMovie.addToFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite_24
                )
            )

        } else {
            binding.contentDetailMovie.addToFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite_border_24
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}