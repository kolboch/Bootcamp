package com.kb.example.loginsample

import java.util.*
import kotlin.concurrent.timerTask

/**
 * Created by Karol on 2017-09-18.
 */
class LoginUser {

    val myFakeDelay = 5000L
    val myFakeCredentials: Credentials = Credentials("johny", "Bravo123")

    fun logInUser(credentials: Credentials, callbackLogin: (Boolean) -> Unit) {
        val timer = Timer()
        timer.schedule(timerTask { callbackLogin(areCredentialsValid(credentials)) }, myFakeDelay)
    }

    private fun areCredentialsValid(credentials: Credentials): Boolean {
        return myFakeCredentials == credentials
    }
}