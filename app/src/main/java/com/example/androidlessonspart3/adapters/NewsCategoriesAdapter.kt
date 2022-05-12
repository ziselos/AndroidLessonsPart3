package com.example.androidlessonspart3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlessonspart3.databinding.HolderNewsCategoryRowBinding

class NewsCategoriesAdapter(private val onCategoryClicked: (NewsCategory) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val categoriesList = arrayListOf<NewsCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsCategoryViewHolder(
            HolderNewsCategoryRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onCategoryClicked

        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsCategoryViewHolder).bind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    fun setList(list: List<NewsCategory>) {
        categoriesList.clear()
        categoriesList.addAll(list)
    }
}

class NewsCategoryViewHolder(private val binding: HolderNewsCategoryRowBinding,
                             private val onCategoryClicked: (NewsCategory) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: NewsCategory) {
        binding.apply {
            categoryButton.text = model.title
            categoryButton.setOnClickListener {
                onCategoryClicked.invoke(model)
            }
        }
    }
}

data class NewsCategory(
    val title: String
)