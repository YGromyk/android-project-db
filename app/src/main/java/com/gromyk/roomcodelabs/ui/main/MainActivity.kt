package com.gromyk.roomcodelabs.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.gromyk.api.auth.AppCredentials.redirectUri
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

    override fun onResume() {
        super.onResume()
        val data = intent.data
        if (AuthData.uri != null && AuthData.uri.toString().startsWith(redirectUri)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            val code = AuthData.uri.getQueryParameter("code")
            if (code != null) {
                Log.d(this::class.java.simpleName, code)
            } else if (AuthData.uri.getQueryParameter("error") != null) {
                // show an error message here
            }
        }
    }
}
