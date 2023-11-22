package com.example.common.cardValidation.utils

/*
 * Credit card parser used to parse credit card Number and IIN
 */
object CreditCardParser {
    /*
     * @param credit card number as a String
     * @return credit card number as a List of Integers
     */
    fun parseNumber(creditCardNumber: String): List<Int> {
        val creditCardNumberList: MutableList<Int> = ArrayList()
        for (number in creditCardNumber.toCharArray()) {
            val tempNumber = Character.getNumericValue(number)
            creditCardNumberList.add(tempNumber)
        }
        return creditCardNumberList
    }

    /*
     * @param credit card number as a List of Integers and
     * the IIN range to test
     * @return the IIN value to test
     */
    fun parseIIN(creditCardNumberList: List<Int?>, range: Int): Int {
        val innString = StringBuilder(range)
        for (i in 0 until range) {
            innString.append(creditCardNumberList[i])
        }
        return innString.toString().toInt()
    }
}