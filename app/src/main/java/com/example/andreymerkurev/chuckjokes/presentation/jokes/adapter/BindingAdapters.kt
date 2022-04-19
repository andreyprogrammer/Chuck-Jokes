package com.example.andreymerkurev.chuckjokes.presentation.jokes.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.andreymerkurev.chuckjokes.domain.entity.Joke

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Joke>?) {
    val adapter = recyclerView.adapter as JokesRecyclerViewAdapter
    adapter.submitList(data)
}