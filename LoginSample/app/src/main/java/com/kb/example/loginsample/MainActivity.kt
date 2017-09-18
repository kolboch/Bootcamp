package com.kb.example.loginsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewsListeners()
        presenter = MainPresenter(this)
    }

    private fun setUpViewsListeners() {
        loginButton.setOnClickListener {
            val login: String = loginEditText.text.toString()
            val password: String = passwordEditText.text.toString()
            presenter?.logIn(Credentials(login, password))
        }
        loginEditText.addTextChangedListener(getTextChangedListener())
        passwordEditText.addTextChangedListener(getTextChangedListener())
    }

    private fun getTextChangedListener(): TextChangedListenerAdapter {
        return object : TextChangedListenerAdapter() {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter?.inputDataChanged(loginEditText.text.toString(), passwordEditText.text.toString())
            }
        }
    }

    override fun showAuthenticatingView() {
        runOnUiThread {
            loadingView.visibility = View.VISIBLE
        }
    }

    override fun hideAuthenticatingView() {
        runOnUiThread {
            loadingView.visibility = View.GONE
        }
    }

    override fun showSuccessfulLoginToast() {
        runOnUiThread {
            toast(R.string.successful_authentication)
        }
    }

    override fun showAuthenticationFailed() {
        runOnUiThread {
            toast(R.string.failed_authentication)
        }
    }

    override fun enableLogInButton() {
        loginButton.isEnabled = true
    }

    override fun disableLogInButton() {
        loginButton.isEnabled = false
    }
}
