package com.seguras.laboratorio1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seguras.laboratorio1.databinding.MovieCardBinding
import com.seguras.laboratorio1.model.Movie

class MovieAdapter(private val context: Context, val movies: ArrayList<Movie>, val onItemListener: OnItemListener): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    val ctx = context
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MovieAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = MovieCardBinding.inflate(layoutInflater)

        return ViewHolder(binding, onItemListener)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bindData(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface OnItemListener{
        fun myClick(movie: Movie)
    }

    class ViewHolder(binding: MovieCardBinding, onItemListener: OnItemListener): RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        private val binding = binding
        private val onItemListener = onItemListener
        private lateinit var movie: Movie

        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemListener.myClick(movie)
        }

        fun bindData(item: Movie){
            with(binding){
                tvTitle.text = item.name
                tvGenre.text = item.genre
                tvRDate.text = item.rdate
                val id = binding.root.resources.getIdentifier(item.image,"drawable", binding.root.context.packageName)
                ivThum.setImageResource(id)
            }
            movie = item
        }
    }
}
