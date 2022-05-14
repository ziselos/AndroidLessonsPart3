package com.example.androidlessonspart3.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.androidlessonspart3.databinding.ActivityDisneyCaharacterDetailsBinding
import com.example.androidlessonspart3.models.api.disney.Data

class DisneyCharacterDetailsActivity : AppCompatActivity() {

    companion object {
        const val DISNEY_CHARACTER_DETAILS = "DISNEY_CHARACTER_DETAILS"
    }

    private lateinit var binding: ActivityDisneyCaharacterDetailsBinding
    private var details: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisneyCaharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras.apply {
            details = this?.getParcelable(DISNEY_CHARACTER_DETAILS)
        }

        setUpUI(details)
    }

    private fun setUpUI(data: Data?) {
        binding.apply {
            name.text = data?.name
            id.text = "ID: ${data?._id}"
            url.text = "Url: ${data?.url}"
            image.load(data?.imageUrl)

        }
    }
}