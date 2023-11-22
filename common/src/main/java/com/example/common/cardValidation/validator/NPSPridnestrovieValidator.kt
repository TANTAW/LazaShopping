package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * NPS Pridnesstrovie format:
 * length = 16
 * IIN range = 6054740 - 6054744
 */
class NPSPridnestrovieValidator(creditCardNumber: String?) : CreditCardValidator() {
    private val creditCardNumberList: List<Int>

    /*
     * @param String representation of credit card number
     */
    init {
        creditCardNumberList = parseNumber(creditCardNumber!!)
    }

    /*
     * Check the length of the card against the format
     * requirement.
     *
     * @return boolean of whether or not credit card
     * number meet requirement.
     */
    public override fun checkLength(): Boolean {
        var hasAllowedLength = false
        if (creditCardNumberList.size == 16) {
            hasAllowedLength = true
        }
        return hasAllowedLength
    }

    /*
     * Check that IIN meets IIN range requirement
     *
     * @return boolean of whether or not IIN matches
     * requirement
     */
    public override fun checkIINRanges(): Boolean {
        var hasAllowedIINRange = false
        val IINRange = intArrayOf(6054740, 6054744)
        val IIN: Int = parseIIN(creditCardNumberList, 7)
        for (i in IINRange[0]..IINRange[1]) {
            if (IIN == i) {
                hasAllowedIINRange = true
                break
            }
        }
        return hasAllowedIINRange
    }
}