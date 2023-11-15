package com.example.domin.addNewCard

import com.ahmed.a.habib.common.DataResult
import kotlinx.coroutines.flow.Flow

interface ICard {
    fun addCard(
        type: CardType,
        cardHolder: String,
        cardNumber: Int,
        expiryDate: String,
        cvv: Int,
        isConfirmed: Boolean
    ): Flow<DataResult<CardDto>>
}