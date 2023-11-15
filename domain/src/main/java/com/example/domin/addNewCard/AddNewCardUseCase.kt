package com.example.domin.addNewCard

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

class AddNewCardUseCase(private val addCard: ICard) {
    operator fun invoke(
        type: CardType,
        cardHolder: String,
        cardNumber: Int,
        expiryDate: String,
        cvv: Int,
        isConfirmed: Boolean
    ): Flow<DataResult<CardDto>> =
        addCard.addCard(type, cardHolder, cardNumber, expiryDate, cvv, isConfirmed)
}