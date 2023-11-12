package com.example.careerexplorer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.careerexplorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private var index = 0
    private val text = "Welcome to career explorer\n The best career explorer in the world!\n Please CLICK Combine Hero to proceed." // Replace with your desired text
    private val delay: Long = 50 // Delay in milliseconds between characters
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Menu bar"
    }

    override fun onResume() {
        super.onResume()
        index = 0 // Reset the index
        binding.textView4.text = "" // Clear the TextView

        // Initialize and start the typewriter effect
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                if (index < text.length) {
                    binding.textView4.append(text[index].toString())
                    index++
                    handler.postDelayed(this, delay)
                }
            }
        }
        handler.post(runnable)
    }

    override fun onPause() {
        handler.removeCallbacks(runnable) // Stop the typewriter effect
        super.onPause()
    }

    override fun onDestroy() {
        handler.removeCallbacks(runnable)
        super.onDestroy()
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

            R.id.menu_suggest_hero -> {
                val emailIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822" // Set MIME type to match email
                    putExtra(
                        Intent.EXTRA_EMAIL,
                        arrayOf("donvgdong052@gmail.com")
                    ) // Recipient's email
                    putExtra(Intent.EXTRA_SUBJECT, "Suggest a Hero")
                    putExtra(Intent.EXTRA_TEXT, "I want to suggest a hero, the hero is ...")
                }

                // Verify that the intent will resolve to an activity
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(Intent.createChooser(emailIntent, "Send email..."))
                } else {
                    // Handle the situation where no compatible email app is available
                    Toast.makeText(this, "No email app available", Toast.LENGTH_SHORT).show()
                }
                true
            }


            R.id.menu_report_technical_problem -> {
                val emailIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822" // Set MIME type to match email
                    putExtra(
                        Intent.EXTRA_EMAIL,
                        arrayOf("donvgdong052@gmail.com")
                    ) // Recipient's email
                    putExtra(Intent.EXTRA_SUBJECT, "Technical Problem Report")
                    putExtra(Intent.EXTRA_TEXT, "I want to report a problem, the problem is ...")
                }

                // Verify that the intent will resolve to an activity
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(Intent.createChooser(emailIntent, "Send email..."))
                } else {
                    // Handle the situation where no compatible email app is available
                    Toast.makeText(this, "No email app available", Toast.LENGTH_SHORT).show()
                }
                true
            }


            R.id.menu_terms_and_conditions -> {
                val intent = Intent(this, menuTerms::class.java)
                startActivity(intent)
                true
            }

            R.id.menu_rate_app -> {
                // Replace 'your.package.name' with your app's package name
                val appPackageName = "com.example.careerexplorer"

                try {
                    // Try to open the app page in Google Play
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=$appPackageName")
                        )
                    )
                } catch (anfe: android.content.ActivityNotFoundException) {
                    // If the Play Store is not installed, open in a web browser
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                        )
                    )
                }
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // ... rest of your code ...
}


