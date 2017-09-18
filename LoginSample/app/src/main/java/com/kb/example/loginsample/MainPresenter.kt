package com.kb.example.loginsample

/**
 * Created by Karol on 2017-09-18.
 */
class MainPresenter(private val view: MainView) {

    val loginUser: LoginUser = LoginUser()

    fun logIn(credentials: Credentials) {
        view.showAuthenticatingView()
        loginUser.logInUser(credentials, {
            when (it) {
                true -> {
                    view.showSuccessfulLoginToast()
                    view.hideAuthenticatingView()
                }
                false -> {
                    view.showAuthenticationFailed()
                    view.hideAuthenticatingView()
                }
            }
        })
    }

    fun inputDataChanged(login: String, password: String) {
        when {
            !loginIsValid(login) -> view.disableLogInButton()
            !passwordIsValid(password) -> view.disableLogInButton()
            else -> view.enableLogInButton()
        }
    }

    private fun loginIsValid(login: String): Boolean {
        return when {
            login.length < 3 -> false
            login.any { it.isDigit() } -> false
            login.any { it.isWhitespace() } -> false
            else -> true
        }
    }

    private fun passwordIsValid(password: String): Boolean {
        return when {
            password.length < 6 -> false
            password.none { it.isDigit() } -> false
            password.none { it.isUpperCase() } -> false
            else -> true
        }
    }
}