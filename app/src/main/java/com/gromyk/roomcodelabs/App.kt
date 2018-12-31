package com.gromyk.roomcodelabs

import android.app.Application
import com.gromyk.api.Server
import timber.log.Timber

/**
 * Created by Yuriy Gromyk on 11/18/18.
 */

class App: Application(){
    override fun onCreate() {
        super.onCreate()
        Server.buildRetrofit()
        configureLogs()
    }

    private fun configureLogs() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}