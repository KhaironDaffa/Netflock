package com.dicoding.netflock.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.netflock.core.databinding.ItemsRowBinding
import com.dicoding.netflock.core.domain.model.TvShow

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private var listShow = ArrayList<TvShow>()
    var onItemClick: ((TvShow) -> Unit)? = null

    fun setShow(show: List<TvShow>?) {
        if (show == null) return
        listShow.clear()
        listShow.addAll(show)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemsRowBinding = ItemsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemsRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = listShow[position]
        holder.bind(show)
    }

    override fun getItemCount() = listShow.size

    inner class ViewHolder(private val binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root) {

        private val posterUrl = "https://image.tmdb.org/t/p/w500"

        fun bind(tvShowEntity: TvShow) {
            with(binding) {
                tvItemTitle.text = tvShowEntity.tvShowTitle

                tvItemDesc.text = tvShowEntity.tvShowDesc

                /*itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailsActivity::class.java)
                    intent.putExtra(DetailsActivity.EXTRA_FLAG, 1)
                    intent.putExtra(DetailsActivity.EXTRA_SHOW, tvShowEntity.tvShowId)
                    intent.putExtra(DetailsActivity.EXTRA_TITLE, tvShowEntity.tvShowTitle)
                    itemView.context.startActivity(intent)
                }*/

                Glide.with(itemView.context)
                    .load(posterUrl + tvShowEntity.tvShowPoster)
                    .apply(RequestOptions().override(110, 170))
                    .into(imgPoster)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listShow[adapterPosition])
            }
        }
    }
}