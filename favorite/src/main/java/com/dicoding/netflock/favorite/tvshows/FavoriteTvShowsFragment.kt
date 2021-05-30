package com.dicoding.netflock.favorite.tvshows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.netflock.core.ui.TvShowAdapter
import com.dicoding.netflock.favorite.databinding.FragmentFavoriteTvShowsBinding
import com.dicoding.netflock.detail.DetailsActivity
import com.dicoding.netflock.di.FavoriteModuleDependencies
import com.dicoding.netflock.favorite.DaggerFavoriteComponent
import com.dicoding.netflock.favorite.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteTvShowsFragment : Fragment() {

    private var _fragmentFavShowsBinding: FragmentFavoriteTvShowsBinding? = null
    private val binding get() = _fragmentFavShowsBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavShowsViewModel by viewModels {
        factory
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _fragmentFavShowsBinding = FragmentFavoriteTvShowsBinding.inflate(inflater, container, false)
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

            val showAdapter = TvShowAdapter()
            showAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.EXTRA_FLAG, 1)
                intent.putExtra(DetailsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            viewModel.favShow.observe(viewLifecycleOwner, { shows ->
                binding?.progressBar?.visibility = View.GONE
                showAdapter.setShow(shows)
            })

            binding?.rvFavShows?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavShows?.setHasFixedSize(true)
            binding?.rvFavShows?.adapter = showAdapter

            /*val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavShowsViewModel::class.java]

            adapter = TvShowAdapter()
            adapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.EXTRA_FLAG, 1)
                intent.putExtra(DetailsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.favShow.observe(viewLifecycleOwner, { shows ->
                binding?.progressBar?.visibility = View.GONE
                adapter.setShow(shows)
            })

            binding?.rvFavShows?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavShows?.setHasFixedSize(true)
            binding?.rvFavShows?.adapter = adapter*/
        }
    }
}