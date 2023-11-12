package com.example.laza.accountCreationChooser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.laza.R
import com.example.laza.core.BaseFragment
import com.example.laza.databinding.FragmentAccountCreationChooserBinding

class AccountCreationChooserFragment :
    BaseFragment<FragmentAccountCreationChooserBinding>(FragmentAccountCreationChooserBinding::inflate){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_AccountCreationChooserFragment_to_IdentityTypeFragment)
        }
    }


}