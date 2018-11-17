package com.gromyk.roomcodelabs.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.gromyk.roomcodelabs.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigationGraph()
    }

    private fun initNavigationGraph() {
        val finalHost = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, finalHost)
            .commit()
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}
