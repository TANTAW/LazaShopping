package com.example.laza.dashboard

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.laza.R
import com.example.laza.databinding.FragmentDashboardBinding
import com.example.laza.utils.BaseFragment

class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

    private val colorTransparent = ColorDrawable(Color.TRANSPARENT)
    private val colorBlue = ColorDrawable(Color.BLUE)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick()
    }

    private fun onClick() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.homeID -> {
                    findNavController().navigate(R.id.homeFragment)
                    binding.bottomNav.menu.findItem(R.id.homeID).icon?.setVisible(false, true)
                }

                R.id.favoriteID -> {
                    findNavController().navigate(R.id.favoriteFragment)
                    binding.bottomNav.menu.findItem(R.id.favoriteID).icon?.setVisible(false, true)
                }

                R.id.wishlistID -> {
                    findNavController().navigate(R.id.wishListFragment)
                    binding.bottomNav.menu.findItem(R.id.wishlistID).icon?.setVisible(false, true)
                }

                R.id.paymentID -> {
                    findNavController().navigate(R.id.paymentFragment)
                    binding.bottomNav.menu.findItem(R.id.paymentID).icon?.setVisible(false, true)
                }
            }
            true
        }
    }
}