package com.ahmed.a.habib.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<BB : ViewBinding>(
    private val inflate: Inflate<BB>
) : Fragment() {

    private var _binding: BB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(
            inflater,
            container,
            false
        )

        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}