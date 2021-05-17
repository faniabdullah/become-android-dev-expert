package com.bangkit.faniabdullah_made.favorite

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
import com.bangkit.faniabdullah_made.databinding.FragmentFavoriteBinding
import com.bangkit.faniabdullah_made.di.FavoriteModuleDependencies
import com.bangkit.faniabdullah_made.favorite.di.DaggerFavoriteModule
import com.bangkit.faniabdullah_made.favorite.di.ViewModelFactory
import com.bangkit.faniabdullah_made.movie_detail.MovieDetailActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
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
        if (activity != null) {

            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, MovieDetailActivity::class.java)
                intent.putExtra(MovieDetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.moviesFavorite.observe(viewLifecycleOwner, { movie ->
                movieAdapter.setData(movie)
                binding.viewEmpty.root.visibility =
                    if (movie.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvMovieFavorite) {
                layoutManager = GridLayoutManager(activity, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}