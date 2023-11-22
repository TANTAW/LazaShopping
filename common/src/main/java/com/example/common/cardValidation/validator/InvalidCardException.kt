package com.example.common.cardValidation.validator

/*
 * Invalid card exception thrown by validator when card
 * does not pass Luhn test.
 */
internal class InvalidCardException(message: String?) : IllegalArgumentException(message)