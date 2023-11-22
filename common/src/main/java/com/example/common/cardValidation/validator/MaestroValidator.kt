package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * Maestro format:
 * length = 12 - 19
 * IIN range = 500000 - 509999, 560000 - 589999, 600000 - 699999
 */
class MaestroValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        if (creditCardNumberList.size in 12..19) {
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
        val innRange = intArrayOf(500000, 509999, 560000, 589999, 600000, 699999)
        val firstSix: Int = parseIIN(creditCardNumberList, 6)
        for (i in innRange[0]..innRange[1]) {
            if (firstSix == i) {
                hasAllowedIINRange = true
                break
            }
        }
        if (!hasAllowedIINRange) {
            for (i in innRange[2]..innRange[3]) {
                if (firstSix == i) {
                    hasAllowedIINRange = true
                    break
                }
            }
        }
        if (!hasAllowedIINRange) {
            for (i in innRange[4]..innRange[5]) {
                if (firstSix == i) {
                    hasAllowedIINRange = true
                    break
                }
            }
        }
        return hasAllowedIINRange
    }
}