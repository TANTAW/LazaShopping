package com.example.domin.checkout

import com.example.common.Resource
import com.example.domin.addToCart.CartDto
import kotlinx.coroutines.flow.Flow

class CheckoutUseCase(private val checkoutRepository: ICheckout) {
    operator fun invoke(cartDto: CartDto): Flow<Resource<CartDto>> = checkoutRepository.checkout(cartDto)
}