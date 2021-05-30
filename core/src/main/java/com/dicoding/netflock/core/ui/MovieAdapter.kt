package com.dicoding.netflock.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.netflock.core.databinding.ItemsRowBinding
import com.dicoding.netflock.core.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var listMovie = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setMovies(movie: List<Movie>?) {
        if (movie == null) return
        listMovie.clear()
        listMovie.addAll(movie)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsRowBinding = ItemsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    override fun getItemCount() = listMovie.size

    inner class ViewHolder(private val binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root) {

        private val posterUrl = "https://image.tmdb.org/t/p/w500"

        fun bind(movie: Movie) {
            with(binding) {
                tvItemTitle.text = movie.movieTitle

                tvItemDesc.text = movie.movieDesc

                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailsActivity::class.java)
                    intent.putExtra(DetailsActivity.EXTRA_FLAG, 0)
                    intent.putExtra(DetailsActivity.EXTRA_MOVIE, movie.movieId)
                    intent.putExtra(DetailsActivity.EXTRA_TITLE, movie.movieTitle)
                    itemView.context.startActivity(intent)
                }*/

                Glide.with(itemView.context)
                    .load(posterUrl + movie.moviePoster)
                    .apply(RequestOptions().override(110, 170))
                    .into(imgPoster)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listMovie[adapterPosition])
            }
        }
    }
}