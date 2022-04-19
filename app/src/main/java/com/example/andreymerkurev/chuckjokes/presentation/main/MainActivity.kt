package com.example.andreymerkurev.chuckjokes.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.andreymerkurev.chuckjokes.R
import com.example.andreymerkurev.chuckjokes.presentation.jokes.JokesFragment
import com.example.andreymerkurev.chuckjokes.presentation.web.WebFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            loadFragment(JokesFragment())
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pageJoke -> {
                    loadFragment(JokesFragment())
                    return@setOnItemSelectedListener true
                }
                else -> {
                    loadFragment(WebFragment())
                    return@setOnItemSelectedListener true
                }

            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
