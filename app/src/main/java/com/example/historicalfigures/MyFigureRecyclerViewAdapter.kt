package com.example.historicalfigures

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.historicalfigures.databinding.FragmentFiguresBinding

import com.squareup.picasso.Callback

class MyFigureRecyclerViewAdapter : ListAdapter<Figure, MyFigureRecyclerViewAdapter.ViewHolder>(FiguresDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentFiguresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: FragmentFiguresBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(figure: Figure) {
            with(binding) {
                name.text = figure.name
                title.text = "Title: ${figure.title}"
                born.text ="Born: ${figure.info.born}"
                died.text ="Died: ${figure.info.died}"
                causeOfDeath.text ="Cause of death: ${figure.info.cause_of_death}"
            }
        }
    }



}
