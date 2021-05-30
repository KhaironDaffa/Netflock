package com.dicoding.netflock.favorite.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.netflock.core.ui.MovieAdapter
import com.dicoding.netflock.favorite.databinding.FragmentFavoriteMoviesBinding
import com.dicoding.netflock.detail.DetailsActivity
import com.dicoding.netflock.di.FavoriteModuleDependencies
import com.dicoding.netflock.favorite.DaggerFavoriteComponent
import com.dicoding.netflock.favorite.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteMoviesFragment : Fragment() {

    private var _fragmentFavMoviesBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _fragmentFavMoviesBinding
    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavMoviesViewModel by viewModels{
        factory
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _fragmentFavMoviesBinding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            adapter = MovieAdapter()
            adapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.EXTRA_FLAG, 0)
                intent.putExtra(DetailsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.favMovie.observe(viewLifecycleOwner, { favMovies ->
                binding?.progressBar?.visibility = View.GONE
                adapter.setMovies(favMovies)
            })

            binding?.rvFavMovies?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavMovies?.setHasFixedSize(true)
            binding?.rvFavMovies?.adapter = adapter
        }
    }
}