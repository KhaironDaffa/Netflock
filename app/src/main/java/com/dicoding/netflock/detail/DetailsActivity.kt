package com.dicoding.netflock.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.netflock.R
import com.dicoding.netflock.core.domain.model.Movie
import com.dicoding.netflock.core.domain.model.TvShow
import com.dicoding.netflock.databinding.ActivityDetailsBinding
import com.dicoding.netflock.databinding.ContentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var detailsBinding: ContentDetailsBinding
    private var isDownload = false

    private val viewModel: DetailsViewModel by viewModels()

    companion object {
        const val EXTRA_FLAG = "extra_flag"
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        detailsBinding = activityDetailsBinding.detailContent

        setContentView(activityDetailsBinding.root)

        setSupportActionBar(activityDetailsBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val flag = intent.getIntExtra(EXTRA_FLAG, 0)

        val extras = intent.extras
        if (flag == 0) {

            if (extras != null) {
                val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
                populateMovie(detailMovie)
                /*val movieId = extras.getInt(EXTRA_MOVIE, 0)

                viewModel.setMovies(movieId)

                viewModel.getMovies.observe(this, { movies ->

                    if (movies != null) {

                        when (movies.status) {

                            Status.LOADING -> activityDetailsBinding.progressBar.visibility = View.VISIBLE

                            Status.SUCCESS ->

                                if (movies.data != null) {


                                    populateMovie(movies.data)

                                }

                            Status.ERROR ->
                                activityDetailsBinding.progressBar.visibility = View.GONE
                        }
                    }
                })*/

            }

            detailsBinding.btnShare.setOnClickListener {
                onShare()
            }

            detailsBinding.btnDownload.setOnClickListener {
                isDownload = !isDownload
                onDownload(isDownload)

                if (isDownload) {
                    Toast.makeText(this@DetailsActivity,"Downloading $title", Toast.LENGTH_LONG).show()
                }

                else {
                    Toast.makeText(this@DetailsActivity,"Deleting $title", Toast.LENGTH_LONG).show()
                }
            }
        }

        else {

            if (extras != null) {
                val detailShow = intent.getParcelableExtra<TvShow>(EXTRA_DATA)
                populateShow(detailShow)
                /*val showId = extras.getInt(EXTRA_SHOW, 0)

                viewModel.setShow(showId)

                viewModel.getShow.observe(this, { shows ->

                    if (shows != null) {

                        when (shows.status) {

                            Status.LOADING -> activityDetailsBinding.progressBar.visibility = View.VISIBLE

                            Status.SUCCESS ->

                                if (shows.data != null) {

                                    activityDetailsBinding.progressBar.visibility = View.GONE
                                    val state = shows.data.favorite
                                    onFavorite(state)


                                }

                            Status.ERROR -> activityDetailsBinding.progressBar.visibility = View.GONE
                        }
                    }
                })*/

            }

            detailsBinding.btnShare.setOnClickListener {
                onShare()
            }

            detailsBinding.btnDownload.setOnClickListener {
                isDownload = !isDownload
                onDownload(isDownload)

                if (isDownload) {
                    Toast.makeText(this@DetailsActivity,"Downloading $title", Toast.LENGTH_LONG).show()
                }

                else {
                    Toast.makeText(this@DetailsActivity,"Deleting $title", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun populateMovie(show: Movie?) {
        val posterUrl = "https://image.tmdb.org/t/p/w500"

        show?.let {
            detailsBinding.textTitle.text = show.movieTitle
            detailsBinding.textDate.text = show.movieDate
            detailsBinding.textDesc.text = show.movieDesc

            Glide.with(this)
                .load(posterUrl + show.moviePoster)
                .apply(RequestOptions().override(200, 270))
                .into(detailsBinding.imagePoster)

            var state = show.favorite
            onFavorite(state)
            detailsBinding.btnLike.setOnClickListener{
                state = !state
                viewModel.setFavMovies(show, state)
                onFavorite(state)
            }
        }
    }

    private fun populateShow(show: TvShow?) {
        val posterUrl = "https://image.tmdb.org/t/p/w500"

        show?.let {
            detailsBinding.textTitle.text = show.tvShowTitle
            detailsBinding.textDate.text = show.tvShowDate
            detailsBinding.textDesc.text = show.tvShowDesc

            Glide.with(this)
                .load(posterUrl + show.tvShowPoster)
                .apply(RequestOptions().override(200, 270))
                .into(detailsBinding.imagePoster)

            var state = show.favorite
            onFavorite(state)
            detailsBinding.btnLike.setOnClickListener{
                state = !state
                viewModel.setFavShows(show, state)
                onFavorite(state)
            }
        }
    }

    private fun onShare() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Share With Your Friends to Share The Fun")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun onFavorite(state: Boolean) {
        if (state) {
            detailsBinding.imgLike.setImageResource(R.drawable.ic_liked)
        }

        else {
            detailsBinding.imgLike.setImageResource(R.drawable.ic_like)
        }
    }

    private fun onDownload(state: Boolean) {
        if (state) {
            detailsBinding.imgDownload.setImageResource(R.drawable.ic_downloaded)
        }

        else {
            detailsBinding.imgDownload.setImageResource(R.drawable.ic_download)
        }
    }
}