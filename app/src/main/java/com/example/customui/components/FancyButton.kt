package com.example.customui.components

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.customui.R

class FancyButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.FancyButton)

        val text = typedArray.getString(R.styleable.FancyButton_buttonText)
        val color = typedArray.getColor(
            R.styleable.FancyButton_buttonColor,
            ContextCompat.getColor(context, android.R.color.holo_blue_dark)
        )
        val radius = typedArray.getDimension(
            R.styleable.FancyButton_cornerRadius,
            24f
        )

        typedArray.recycle()

        this.text = text ?: "Fancy Button"

        val backgroundDrawable = GradientDrawable()
        backgroundDrawable.setColor(color)
        backgroundDrawable.cornerRadius = radius
        background = backgroundDrawable

        setTextColor(ContextCompat.getColor(context, android.R.color.white))
        textSize = 16f
    }
}