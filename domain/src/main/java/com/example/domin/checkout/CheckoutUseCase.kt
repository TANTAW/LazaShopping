package com.example.domin.checkout

import com.example.common.DataResult
import com.example.domin.addToCart.CartDto
import kotlinx.coroutines.flow.Flow

class CheckoutUseCase(private val checkoutRepository: ICheckout) {
    operator fun invoke(cartDto: CartDto): Flow<DataResult<CartDto>> = checkoutRepository.checkout(cartDto)
}