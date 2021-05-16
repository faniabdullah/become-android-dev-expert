package com.bangkit.faniabdullah_made.movie

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bangkit.faniabdullah_made.R
import com.bangkit.faniabdullah_made.core.data.Resource
import com.bangkit.faniabdullah_made.core.ui.MovieAdapter
import com.bangkit.faniabdullah_made.databinding.FragmentMovieBinding
import com.bangkit.faniabdullah_made.movie_detail.MovieDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModels()
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding as FragmentMovieBinding
    private lateinit var searchView: SearchView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, MovieDetailActivity::class.java)
                intent.putExtra(MovieDetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            movieViewModel.movieResult.observe(viewLifecycleOwner, { movie ->
                if (searchView.query.toString() == "") {
                    binding.viewError.root.visibility = View.GONE
                    observerMovie()
                } else {
                    if (movie.isNullOrEmpty()) {
                        binding.viewError.root.visibility = View.VISIBLE
                    } else {
                        binding.viewError.root.visibility = View.GONE
                    }
                    movieAdapter.setData(movie)
                }
            })


            with(binding.rvMovie) {
                layoutManager = GridLayoutManager(activity, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
            observerMovie()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.search_menu).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.queryHint = resources.getString(R.string.menu_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(newText: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {

                newText.let {
                    if (newText == "" || newText.isEmpty()) {
                        observerMovie()
                    } else {
                        movieViewModel.setSearchQuery(it)
                    }
                }
                return true
            }
        })

        super.onCreateOptionsMenu(menu, inflater)

    }

    private fun observerMovie() {
        movieViewModel.movies.observe(viewLifecycleOwner, { movie ->
            if (movie != null) {
                when (movie) {
                    is com.bangkit.faniabdullah_made.core.data.Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is com.bangkit.faniabdullah_made.core.data.Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        movieAdapter.setData(movie.data)
                    }
                    is com.bangkit.faniabdullah_made.core.data.Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvMsgError.text =
                            movie.message ?: getString(R.string.notification_error)
                    }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}