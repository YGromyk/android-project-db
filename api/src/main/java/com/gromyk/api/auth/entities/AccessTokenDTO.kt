package com.gromyk.api.auth.entities

import com.google.gson.annotations.SerializedName

data class AccessTokenDTO(
    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("scope")
    val scope: String? = null ,
    @SerializedName("token_type")
    val tokenType: String?  = null
)