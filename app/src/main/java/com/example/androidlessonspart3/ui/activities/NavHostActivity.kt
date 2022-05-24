package com.example.androidlessonspart3.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlessonspart3.databinding.ActivityNavHostBinding

class NavHostActivity: AppCompatActivity() {

    private lateinit var binding: ActivityNavHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}