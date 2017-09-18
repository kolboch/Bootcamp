package com.kb.example.loginsample

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by Karol on 2017-09-18.
 */
open class TextChangedListenerAdapter : TextWatcher {
    override fun afterTextChanged(p0: Editable?) {
        // adapter class intentionally left empty
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // adapter class intentionally left empty
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        // adapter class intentionally left empty
    }
}