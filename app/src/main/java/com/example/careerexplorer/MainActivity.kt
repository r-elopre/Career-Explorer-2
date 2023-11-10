package com.example.careerexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.careerexplorer.databinding.ActivityMainBinding // Update this with the correct name of your generated binding class

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Replacing setContentView with DataBindingUtil
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Now you can use 'binding' to access your views
        // Example: binding.textView.text = "Hello Data Binding!"
    }
}
