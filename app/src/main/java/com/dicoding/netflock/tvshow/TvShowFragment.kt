package com.dicoding.netflock.tvshow

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
import com.dicoding.netflock.core.ui.TvShowAdapter
import com.dicoding.netflock.databinding.FragmentTvShowBinding
import com.dicoding.netflock.detail.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    private val viewModel: TvShowViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val tvShowAdapter = TvShowAdapter()
            tvShowAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.EXTRA_FLAG, 1)
                intent.putExtra(DetailsActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            viewModel.show.observe(viewLifecycleOwner, { shows ->
                if (shows != null) {
                    when (shows) {
                        is Resource.Loading -> fragmentTvShowBinding.progressBar.visibility = View.VISIBLE

                        is Resource.Success -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            tvShowAdapter.setShow(shows.data)
                        }

                        is Resource.Error -> {
                            fragmentTvShowBinding.progressBar.visibility = View.GONE
                            context?.let { Toasty.error(it, "Something Went Wrong", Toast.LENGTH_SHORT).show() }
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

}