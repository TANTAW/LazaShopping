package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseNumber
import java.util.Collections

/*
 * Luhn validator used to pass the credit card number through
 * a series of algorithm checks that confirm whether or not the
 * number are valid
 */
internal class LuhnValidator {
    /*
     * @param String representation of the credit card number.
     * @return boolean of whether or not the number pass the
     * algorithm check.
     */
    fun validate(creditCardNumber: String): Boolean {
        return algorithmCheck(creditCardNumber)
    }

    /*
     * @param int of number that should be split into individual
     * digits
     * @return the sum of the digits
     */
    private fun sumOfDigits(number: Int): Int {
        val tempNumberArray =
            Integer.toString(number).split("".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
        var total = 0
        for (digit in tempNumberArray) {
            total += digit.toInt()
        }
        return total
    }

    /*
     * @param String representation of the credit card number
     * @return boolean of whether or not the number pass the
     * Luhn algorithm check
     */
    private fun algorithmCheck(creditCardNumber: String): Boolean {
        val numberList: List<Int> = parseNumber(creditCardNumber)
        var isValid = false
        val listSize = numberList.size
        val tempArray = IntArray(listSize)
        var sum = 0

        // Reverse the order
        Collections.reverse(numberList)

        // Double the value of every second digit
        run {
            var i = 1
            while (i < listSize) {
                val tempNumber = numberList[i] * 2

                /*
             * If doubling results in a single digit number then add it to list
             * otherwise, add each digit together to obtain a single digit number
            */if (tempNumber < 10) {
                    tempArray[i] = tempNumber
                } else {
                    tempArray[i] = sumOfDigits(tempNumber)
                }
                i += 2
            }
        }

        // Add the remaining digits
        var i = 0
        while (i < listSize) {
            tempArray[i] = numberList[i]
            i += 2
        }

        // Take sum of all digits
        for (number in tempArray) {
            sum += number
        }
        // If total modulo 10 is equal to 0 then the card is valid
        if (sum % 10 == 0) {
            isValid = true
        }
        return isValid
    }
}