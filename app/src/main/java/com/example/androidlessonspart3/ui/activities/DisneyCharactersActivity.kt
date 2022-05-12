package com.example.androidlessonspart3.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlessonspart3.adapters.DisneyCharactersAdapter
import com.example.androidlessonspart3.api.APIInterface
import com.example.androidlessonspart3.api.DisneyAPIClient
import com.example.androidlessonspart3.databinding.ActivityDisneyCharactersBinding
import com.example.androidlessonspart3.models.api.disney.Data
import kotlinx.coroutines.*

class DisneyCharactersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisneyCharactersBinding

    private var apiInterface: APIInterface? = null
    private var job: Job? = null
    private lateinit var adapter: DisneyCharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisneyCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        fetchDisneyCharacters()
    }

    private fun fetchDisneyCharacters() {
        apiInterface = DisneyAPIClient.disneyClient?.create(APIInterface::class.java)
        binding.loader.visibility = View.VISIBLE
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface?.getDisneyCharacters()
            withContext(Dispatchers.Main) {
                // hide loader
                binding.loader.visibility = View.GONE
                if (response?.isSuccessful == true) {
                    binding.errorText.visibility = View.GONE
                    adapter.setList(response.body()?.data as ArrayList<Data>)
                    adapter.notifyDataSetChanged()
                    Log.d("Disney", response.body()?.data?.size.toString())
                } else {
                    // error handling
                    binding.errorText.visibility = View.VISIBLE
                    Log.d("Disney", response?.errorBody().toString())
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = DisneyCharactersAdapter()
        binding.disneyRecyclerView.adapter = adapter
    }

}