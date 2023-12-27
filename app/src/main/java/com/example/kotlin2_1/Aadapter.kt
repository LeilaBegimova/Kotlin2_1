package com.example.kotlin2_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2_1.databinding.ItemAnimeBinding

class Aadapter(val onClickable: OnClickable) : RecyclerView.Adapter<Aadapter.AViewHolder>() {

    private lateinit var animeList: List<Data>

    fun setDataAnimeList(data: List<Data>) {
        animeList = data
    }

    inner class AViewHolder(val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Data) {
            binding.imageItem.setImageResource(position.image)
            binding.animeTitle.text = position.name
            binding.root.setOnClickListener {
                onClickable.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AViewHolder {
        return AViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: AViewHolder, position: Int) {
        holder.onBind(animeList[position])
    }
}
