package com.dicoding.netflock.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.netflock.core.data.Resource
import com.dicoding.netflock.core.ui.MovieAdapter
import com.dicoding.netflock.databinding.FragmentMoviesBinding
import com.dicoding.netflock.detail.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.EXTRA_FLAG, 0)
                intent.putExtra(DetailsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            viewModel.movie.observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies) {
                        is Resource.Loading -> fragmentMoviesBinding.progressBar.visibility = View.VISIBLE

                        is Resource.Success -> {
                            fragmentMoviesBinding.progressBar.visibility = View.GONE
                            movieAdapter.setMovies(movies.data)
                        }

                        is Resource.Error -> {
                            fragmentMoviesBinding.progressBar.visibility = View.GONE
                            context?.let { Toasty.error(it, "Something Went Wrong", Toast.LENGTH_SHORT).show() }
                        }
                    }
                }
            })

            with(fragmentMoviesBinding.rvMovies) {
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

}