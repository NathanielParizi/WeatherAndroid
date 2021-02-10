package com.example.weatherandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weatherandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navigation: Navigation
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Android App"

        binding.navigationBottomBar.setupWithNavController(findNavController(R.id.nav_host_fragment))

    }


    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()


}