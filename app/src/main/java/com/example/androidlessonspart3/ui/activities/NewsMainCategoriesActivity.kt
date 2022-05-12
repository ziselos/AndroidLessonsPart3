package com.example.androidlessonspart3.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlessonspart3.adapters.NewsCategoriesAdapter
import com.example.androidlessonspart3.adapters.NewsCategory
import com.example.androidlessonspart3.databinding.ActivityNewsMainCategoriesBinding

class NewsMainCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsMainCategoriesBinding
    private lateinit var newsCategoriesAdapter: NewsCategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsMainCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMainCategoriesRecyclerView()
    }

    private fun initMainCategoriesRecyclerView() {
        binding.apply {
            newsCategoriesAdapter = NewsCategoriesAdapter(
                onCategoryClicked = {
                    Toast.makeText(this@NewsMainCategoriesActivity,
                        "You click " + it.title, Toast.LENGTH_SHORT).show()
                }
            )
            newsCategoriesAdapter.setList(getNewsCategories())
            categoriesRecyclerView.adapter = newsCategoriesAdapter
        }
    }
}

fun getNewsCategories(): ArrayList<NewsCategory> {
    val listToReturn = arrayListOf<NewsCategory>()
    listToReturn.add(NewsCategory(title = "All"))
    listToReturn.add(NewsCategory(title = "national"))
    listToReturn.add(NewsCategory(title = "business"))
    listToReturn.add(NewsCategory(title = "sports"))
    listToReturn.add(NewsCategory(title = "world"))
    listToReturn.add(NewsCategory(title = "politics"))
    listToReturn.add(NewsCategory(title = "technology"))
    listToReturn.add(NewsCategory(title = "startup"))
    listToReturn.add(NewsCategory(title = "entertainment"))
    listToReturn.add(NewsCategory(title = "miscellaneous"))
    listToReturn.add(NewsCategory(title = "hatke"))
    listToReturn.add(NewsCategory(title = "science"))
    listToReturn.add(NewsCategory(title = "automobile"))

    return listToReturn
}