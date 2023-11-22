package com.example.domin.addNewCard

import androidx.core.text.isDigitsOnly
import com.example.common.Resource
import com.example.common.TextUI
import com.example.common.cardValidation.validator.Validator
import com.example.common.remote.ErrorTypes
import com.example.domin.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AddNewCardUseCase(private val addCard: ICard) {
    private lateinit var validator: Validator
    operator fun invoke(
        type: CardType,
        cardHolder: String,
        cardNumber: String,
        expiryDate: String,
        cvv: String,
    ): Flow<Resource<CardDto>> {
        if (cardHolder.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_card_holder))))
        if (cardNumber.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_card_number))))
        if (expiryDate.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_date))))
        if (cvv.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_cvv))))
        if (!cardNumber.isDigitsOnly())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.invalid_card_number))))
        if (!cvv.isDigitsOnly())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.invalid_cvv))))
        validator = Validator(cardNumber, expiryDate, cvv)
        if (validator.validate())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.invalid_card_number))))
        if (validator.checkCVV())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.invalid_cvv))))
        if (validator.checkExpirationDate())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.invalid_date))))
        return addCard.addCard(type, cardHolder, cardNumber, expiryDate, cvv)
    }

}