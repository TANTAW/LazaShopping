package com.example.laza.login

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.common.BaseFragment
import com.example.laza.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showText()
        onClickListener()
        setUpViewModel()
        observer()
    }

    private fun observer() {
        viewModel.success.observe(viewLifecycleOwner){
//            navigateTo()
        }
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
    }

    private fun onClickListener() {
        binding.loginBTN.setOnClickListener {
            val username = binding.etUserName.editText?.text.toString()
            val password = binding.etPassword.editText?.text.toString()
            viewModel.login(username, password)
        }
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

        binding.tvTermsAndCondition.text = text
    }


}