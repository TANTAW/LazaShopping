package com.example.common

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

class SeeMoreTextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    private val seeMoreText = "See More"
    private val seeLessText = "See Less"
    private var maxLinesToShow = 2
    private var isExpanded = false

    init {
        // Make the "See More" text clickable
        movementMethod = LinkMovementMethod.getInstance()
        highlightColor = Color.TRANSPARENT

        // Set the initial state of the TextView
        updateText()

        // Handle clicks on "See More" and "See Less"
        setOnClickListener {
            isExpanded = !isExpanded
            updateText()
        }
    }

    fun setMaxLinesToShow(maxLines: Int) {
        maxLinesToShow = maxLines
        updateText()
    }

    fun setTextAndContent(text: String) {
        this.text = text
        updateText()
    }

    private fun updateText() {
        val originalText = text.toString()
        if (originalText.split("\n").size > maxLinesToShow) {
            val truncatedText = if (isExpanded) originalText else originalText.split("\n")
                .subList(0, maxLinesToShow)
                .joinToString("\n")
            val seeMoreClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    isExpanded = true
                    updateText()
                }
            }

            val seeLessClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    isExpanded = false
                    updateText()
                }
            }

            val spannableStringBuilder = SpannableStringBuilder(truncatedText)

            if (isExpanded) {
                spannableStringBuilder.append(
                    " $seeLessText",
                    seeLessClickableSpan,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            } else {
                spannableStringBuilder.append(
                    " $seeMoreText",
                    seeMoreClickableSpan,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            setText(spannableStringBuilder, BufferType.SPANNABLE)
        } else {
            // If text doesn't exceed maxLinesToShow, no need for "See More" or "See Less"
            text = originalText
        }
    }
}
