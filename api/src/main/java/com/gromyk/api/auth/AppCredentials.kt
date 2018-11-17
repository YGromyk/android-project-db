package com.gromyk.api.auth

/**
 * Created by Yuriy Gromyk on 11/18/18.
 */

object AppCredentials {
    public val ClientID = "6cdfa8f77d6ec06e33bb"
    public val ClientSecret = "3c492e2ff65a104175ac0bcb96d2828acc39c86d"
    public val Callback = "gromyk://callback"
    public val GithubLink = "https://github.com/login/oauth/authorize"
    public val clientIdParam = "?client_id="
    public val repoScope = "&scope=repo"
    public val redirectUri = "&redirect_uri="
}