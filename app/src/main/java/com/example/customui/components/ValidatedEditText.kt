package com.example.customui.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.customui.R

class ValidatedEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {

    private var isEmailField: Boolean = false

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ValidatedEditText)

        hint = typedArray.getString(R.styleable.ValidatedEditText_hintText)
        isEmailField = typedArray.getBoolean(R.styleable.ValidatedEditText_isEmail, false)

        typedArray.recycle()
    }

    fun isValid(): Boolean {
        val inputText = text.toString()
        return if (isEmailField) {
            android.util.Patterns.EMAIL_ADDRESS.matcher(inputText).matches()
        } else {
            inputText.isNotEmpty()
        }
    }
}