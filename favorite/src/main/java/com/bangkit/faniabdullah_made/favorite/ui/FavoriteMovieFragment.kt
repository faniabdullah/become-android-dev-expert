package com.bangkit.faniabdullah_made.favorite.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bangkit.faniabdullah_made.core.ui.MovieAdapter
import com.bangkit.faniabdullah_made.di.FavoriteModuleDependencies
import com.bangkit.faniabdullah_made.favorite.databinding.FragmentMovieFavoriteBinding
import com.bangkit.faniabdullah_made.favorite.di.DaggerFavoriteModule
import com.bangkit.faniabdullah_made.favorite.di.ViewModelFactory
import com.bangkit.faniabdullah_made.movie_detail.MovieDetailActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteMovieFragment(private val isMovie: Boolean) : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private var _binding: FragmentMovieFavoriteBinding? = null

    private val binding get() = _binding as FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteModule.builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, MovieDetailActivity::class.java)
            intent.putExtra(MovieDetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        if (isMovie) {
            favoriteViewModel.moviesFavorite.observe(viewLifecycleOwner, { movie ->
                movieAdapter.setData(movie)
                viewEmpty(movie.isNotEmpty())
            })
        } else {
            favoriteViewModel.tvShowsFavorite.observe(viewLifecycleOwner, { movie ->
                movieAdapter.setData(movie)
                viewEmpty(movie.isNotEmpty())
            })
        }

        with(binding.rvMovieFav) {
            layoutManager = GridLayoutManager(activity, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    private fun viewEmpty(notEmpty: Boolean) {
        if (notEmpty) {
            binding.tvMsgError.visibility - View.GONE
            binding.imageView.visibility = View.GONE
        } else {
            binding.tvMsgError.visibility - View.VISIBLE
            binding.imageView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvMovieFav.adapter = null
        _binding = null
    }
}