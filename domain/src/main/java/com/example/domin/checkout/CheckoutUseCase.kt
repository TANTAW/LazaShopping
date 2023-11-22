package com.example.domin.checkout


import com.example.domin.addToCart.CartDto

class CheckoutUseCase(private val checkoutRepository: ICheckout) {

    operator fun invoke(cartDto: CartDto) = checkoutRepository.checkout(cartDto)
}