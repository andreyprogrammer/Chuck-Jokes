package com.example.andreymerkurev.chuckjokes.presentation.jokes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.andreymerkurev.chuckjokes.databinding.ItemJokeBinding
import com.example.andreymerkurev.chuckjokes.domain.entity.Joke

class JokesRecyclerViewAdapter :
    ListAdapter<Joke, JokesRecyclerViewAdapter.JokesViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        return JokesViewHolder(ItemJokeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        val joke = getItem(position)
        holder.bind(joke)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(old: Joke, aNew: Joke): Boolean {
            return old === aNew
        }

        override fun areContentsTheSame(old: Joke, aNew: Joke): Boolean {
            return old.id == aNew.id
        }
    }

    class JokesViewHolder(private var binding: ItemJokeBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(joke: Joke) {
            binding.jokeCard = joke
            binding.executePendingBindings()
        }
    }
}