package com.example.data.checkout.models

import com.example.domin.addNewCard.CardType

data class CardModel(
    val type: CardType,
    val cardHolder: String,
    val cardNumber: String,
    val expiryDate: String,
    val cvv: String,
    val isConfirmed: Boolean = false
)