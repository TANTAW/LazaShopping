package com.example.domin.addNewCard

data class CardDto(
    val type: CardType,
    val cardHolder: String,
    val cardNumber: Int,
    val expiryDate: String,
    val cvv: Int,
    val isConfirmed: Boolean = false
)
