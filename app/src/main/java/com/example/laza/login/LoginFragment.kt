package com.example.laza.login

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import com.ahmed.a.habib.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private lateinit var textview: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showText()
    }

    private fun showText() {
        val string =
            "By connecting your account confirm that you agree with our Terms and Conditions"
        val text =
            SpannableString(string)
        val foregroundColor = ForegroundColorSpan(Color.BLACK)
        text.setSpan(
            foregroundColor,
            string.lastIndexOf("Terms"),
            string.length - 1,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textview = requireView().findViewById(R.id.tv_terms_and_condition)
        textview.text = text
    }
}