package com.gromyk.api.auth

import com.gromyk.api.auth.entities.AccessTokenDTO
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Yuriy Gromyk on 11/17/18.
 */
interface AuthService {

    @POST("access_token")
    @FormUrlEncoded
    fun getAccessToken(
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("code") code: String
    ): Observable<Response<AccessTokenDTO>>

}