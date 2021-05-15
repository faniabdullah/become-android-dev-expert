package com.bangkit.faniabdullah_made.movie_detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.faniabdullah_made.R
import com.bangkit.faniabdullah_made.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    companion object {
        const val EXTRA_DATA = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}