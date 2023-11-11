package com.example.careerexplorer

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.careerexplorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Replacing setContentView with DataBindingUtil
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set the toolbar as the app's action bar
        setSupportActionBar(binding.toolbar)

        // Change the title after setting the Toolbar
        supportActionBar?.title = "Menu Bar"

        // Now you can use 'binding' to access your views
        // Example: binding.textView.text = "Hello Data Binding!"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu) // Ensure your menu file is named 'menu.xml'
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_app_goal -> {
                val intent = Intent(this, menuAppGoal::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_subscription_offer -> {
                val intent = Intent(this, menuSubscription::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_report_technical_problem -> {
                val intent = Intent(this, menuReport::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_suggest_hero -> {
                val intent = Intent(this, menuSuggest::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_terms_and_conditions -> {
                val intent = Intent(this, menuTerms::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_rate_app -> {
                val intent = Intent(this, menuRate::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
