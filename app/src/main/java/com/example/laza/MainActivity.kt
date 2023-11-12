package com.example.laza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.laza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.homeID -> {
                    Navigation.findNavController(binding.dashboardNavGraph).navigate(R.id.homeFragment)
                    binding.bottomNav.menu.findItem(R.id.homeID).icon?.setVisible(false, true)
                }

                R.id.favoriteID -> {
                    Navigation.findNavController(binding.dashboardNavGraph).navigate(R.id.favoriteFragment)
                    binding.bottomNav.menu.findItem(R.id.favoriteID).icon?.setVisible(false, true)
                }

                R.id.wishlistID -> {
                    Navigation.findNavController(binding.dashboardNavGraph).navigate(R.id.wishListFragment)
                    binding.bottomNav.menu.findItem(R.id.wishlistID).icon?.setVisible(false, true)
                }

                R.id.paymentID -> {
                    Navigation.findNavController(binding.dashboardNavGraph).navigate(R.id.paymentFragment)
                    binding.bottomNav.menu.findItem(R.id.paymentID).icon?.setVisible(false, true)
                }
            }

            true
        }
    }
}