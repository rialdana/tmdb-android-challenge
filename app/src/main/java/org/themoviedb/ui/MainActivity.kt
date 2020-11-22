package org.themoviedb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.themoviedb.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting the navHostFragment instance
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment

        // Getting the navController
        val navController = host.navController

        // Getting the bottom nav instance
        val toolbar = findViewById<Toolbar>(R.id.toolbar_tmdb)

        // Setting up the bottomNav with the navController so we can navigate
        toolbar?.setupWithNavController(navController)
    }


}