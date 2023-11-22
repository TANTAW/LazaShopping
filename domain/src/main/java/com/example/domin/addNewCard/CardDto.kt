package com.example.domin.addNewCard

data class CardDto(
    val type: CardType,
    val cardHolder: String,
    val cardNumber: String,
    val expiryDate: String,
    val cvv: String,
    val isConfirmed: Boolean = false
)
