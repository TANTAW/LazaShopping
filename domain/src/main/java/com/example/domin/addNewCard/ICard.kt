package com.example.domin.addNewCard

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface ICard {
    fun addCard(
        type: CardType,
        cardHolder: String,
        cardNumber: String,
        expiryDate: String,
        cvv: String
    ): Flow<Resource<CardDto>>
}
