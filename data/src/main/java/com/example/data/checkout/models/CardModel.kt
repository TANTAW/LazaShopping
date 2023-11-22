package com.example.data.checkout.models

import com.example.domin.addNewCard.CardType

data class CardModel(
    val type: CardType,
    val cardHolder: String,
    val cardNumber: Int,
    val expiryDate: String,
    val cvv: Int,
    val isConfirmed: Boolean = false
)