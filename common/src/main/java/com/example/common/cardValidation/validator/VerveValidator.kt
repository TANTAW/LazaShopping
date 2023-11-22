package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * Verve format:
 * length = 16 - 19
 * IIN range = 506099 - 506198, 650002 - 650027
 */
class VerveValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        if (creditCardNumberList.size in 16..19) {
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
        val IINRange = intArrayOf(506099, 506198, 650002, 650027)
        val IIN: Int = parseIIN(creditCardNumberList, 6)
        for (i in IINRange[0]..IINRange[1]) {
            if (IIN == i) {
                hasAllowedIINRange = true
                break
            }
        }
        if (!hasAllowedIINRange) {
            for (i in IINRange[0]..IINRange[1]) {
                if (IIN == i) {
                    hasAllowedIINRange = true
                    break
                }
            }
        }
        return hasAllowedIINRange
    }
}