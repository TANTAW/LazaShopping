package com.example.data.checkout.models

import com.example.domin.addAddress.AddressDto

data class CartRequest(
    val items: List<CartProductModel>,
    val address: AddressDto,
    val card: CardModel,
    val calculations: OrderInfoModel
)
