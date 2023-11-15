package com.example.domin.checkout

import com.example.common.DataResult
import com.example.domin.addToCart.CartDto
import kotlinx.coroutines.flow.Flow

interface ICheckout {
    fun checkout(cart: CartDto): Flow<DataResult<CartDto>>
}
