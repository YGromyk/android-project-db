package com.gromyk.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Yuriy Gromyk on 11/18/18.
 */

object Server {
    @JvmStatic
    val apiBaseUrl = "https://api.github.com"
    @JvmStatic
    var retrofit: Retrofit? = null
        private set

    fun buildRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }
}