package com.kb.example.loginsample

/**
 * Created by Karol on 2017-09-18.
 */
interface MainView {

    fun showAuthenticatingView()
    fun hideAuthenticatingView()

    fun showSuccessfulLoginToast()
    fun showAuthenticationFailed()

    fun enableLogInButton()
    fun disableLogInButton()
}