package com.gromyk.roomcodelabs.ui.main

import android.net.Uri
import com.gromyk.api.auth.AppCredentials.Callback
import com.gromyk.api.auth.AppCredentials.ClientID
import com.gromyk.api.auth.AppCredentials.GithubLink
import com.gromyk.api.auth.AppCredentials.clientIdParam
import com.gromyk.api.auth.AppCredentials.redirectUri
import com.gromyk.api.auth.AppCredentials.repoScope


/**
 * Created by Yuriy Gromyk on 11/18/18.
 */

object AuthData {
    val uri = Uri.parse("$GithubLink$clientIdParam$ClientID$repoScope$redirectUri$Callback")
}