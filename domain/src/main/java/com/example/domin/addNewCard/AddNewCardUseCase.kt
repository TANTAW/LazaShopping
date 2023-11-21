package com.example.domin.addNewCard

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

class AddNewCardUseCase(private val addCard: ICard) {
    operator fun invoke(
        type: CardType,
        cardHolder: String,
        cardNumber: Int,
        expiryDate: String,
        cvv: Int
    ): Flow<Resource<CardDto>> =
        addCard.addCard(type, cardHolder, cardNumber, expiryDate, cvv)
}