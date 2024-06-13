package com.example.orderbyoccurrences

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.orderbyoccurrences.databinding.ItemListBinding

class MyListAdapter(val list: List<Pair<String, Int>>) : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<String, Int>) {
            binding.tvName.text = item.first
            binding.tvQuantity.text = item.second.toString()
        }
    }
}