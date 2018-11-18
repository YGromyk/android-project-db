package com.gromyk.roomcodelabs.ui.auth.signin

import android.arch.lifecycle.MutableLiveData
import com.gromyk.api.Server
import com.gromyk.api.auth.AppCredentials
import com.gromyk.api.auth.AuthService
import com.gromyk.api.auth.entities.AccessTokenDTO
import com.gromyk.roomcodelabs.ui.base.BaseViewModel
import com.gromyk.roomcodelabs.utils.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Yuriy Gromyk on 11/18/18.
 */

class SignInViewModel : BaseViewModel() {
    val signInData = MutableLiveData<AccessTokenDTO>()

    fun getAccessToken(code: String) {
        Server.retrofit?.create(AuthService::class.java)
            ?.getAccessToken(
                clientId = AppCredentials.ClientID,
                clientSecret = AppCredentials.ClientSecret,
                code = code
            )
            ?.observeOn(Schedulers.io())
            ?.subscribeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    signInData.value = it.body()
                    Timber.i("$it")
                },
                { Timber.e(it) }
            )
            ?.addTo(disposable)
    }
}