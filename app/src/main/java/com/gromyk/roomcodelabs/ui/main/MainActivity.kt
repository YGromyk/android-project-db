package com.gromyk.roomcodelabs.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.gromyk.roomcodelabs.R
import timber.log.Timber

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

    override fun onPostResume() {
        super.onPostResume()
        val data = intent.data
        data?.let {
            val code = data.getQueryParameter("code")
            Timber.e("Code id $code")
            val bundle = Bundle()
            bundle.putString(getString(R.string.oAuthCode), code)
            findNavController(R.id.nav_host_fragment).navigate(R.id.action_authFragment_to_signInFragment, bundle)
        }
    }
}
