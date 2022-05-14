package com.example.androidlessonspart3.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidlessonspart3.databinding.HolderDisneyCharacterBinding
import com.example.androidlessonspart3.models.api.disney.Data

class DisneyCharactersAdapter(private val onCharacterClicked: (Data) -> Unit) :
    RecyclerView.Adapter<DisneyCharacterViewHolder>() {

    private val disneyCharactersList = arrayListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisneyCharacterViewHolder {
        return DisneyCharacterViewHolder(
            HolderDisneyCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onCharacterClicked
        )
    }

    override fun onBindViewHolder(holder: DisneyCharacterViewHolder, position: Int) {
        holder.bind(disneyCharactersList[position])
    }

    override fun getItemCount(): Int = disneyCharactersList.size

    fun setList(dataList: List<Data>) {
        disneyCharactersList.clear()
        disneyCharactersList.addAll(dataList)
    }
}

class DisneyCharacterViewHolder(
    private val binding: HolderDisneyCharacterBinding,
    private val onCharacterClicked: (Data) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Data) {
        binding.apply {
            name.text = model.name
            info.text = model.url
            image.load(model.imageUrl)

            itemView.setOnClickListener {
                onCharacterClicked.invoke(model)
            }
        }
    }
}