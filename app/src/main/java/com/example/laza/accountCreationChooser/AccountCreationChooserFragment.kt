package com.example.laza.accountCreationChooser

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.common.BaseFragment
import com.example.laza.R
import com.example.laza.databinding.FragmentAccountCreationChooserBinding

class AccountCreationChooserFragment :
    BaseFragment<FragmentAccountCreationChooserBinding>(FragmentAccountCreationChooserBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_AccountCreationChooserFragment_to_IdentityTypeFragment)
        }
    }


}