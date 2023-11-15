package com.example.domin.checkout

import com.example.domin.addToCart.CartDto
import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

interface ICheckout {
    fun checkout(cart: CartDto): Flow<Resource<CartDto>>
}
