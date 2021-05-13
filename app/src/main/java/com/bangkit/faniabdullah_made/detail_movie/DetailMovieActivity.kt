package com.bangkit.faniabdullah_made.detail_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.faniabdullah_made.R
import com.bangkit.faniabdullah_made.databinding.ActivityDetailMovieBinding
import com.bangkit.faniabdullah_made.databinding.ActivityMainBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    companion object{
        const val EXTRA_DATA = "extra_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}