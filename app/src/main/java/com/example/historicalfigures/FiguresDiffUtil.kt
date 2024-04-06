package com.example.historicalfigures

import androidx.recyclerview.widget.DiffUtil

class FiguresDiffUtil : DiffUtil.ItemCallback<Figure>() {
    override fun areItemsTheSame(oldItem: Figure, newItem: Figure): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Figure, newItem: Figure): Boolean {
        return oldItem == newItem
    }
}