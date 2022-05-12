package com.example.androidlessonspart3.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.androidlessonspart3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout() {
        binding.apply {
            disneyApiCall.setOnClickListener {
                Intent(this@MainActivity, DisneyCharactersActivity::class.java
                ).also {
                    startActivity(it)
                }
            }
        }
    }
}