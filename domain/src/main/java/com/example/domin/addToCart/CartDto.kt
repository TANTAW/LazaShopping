package com.example.domin.addToCart

import com.example.domin.addAddress.AddressDto
import com.example.domin.addNewCard.CardDto

data class CartDto(
    val items: List<CartProductDto>,
    val address: AddressDto,
    val card: CardDto,
    val calculations: OrderInfoDto
)
