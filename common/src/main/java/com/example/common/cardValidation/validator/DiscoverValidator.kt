package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber


/*
 * Discover format:
 * length = 16
 * IIN range = 6011, 622126 - 622925, 644 - 649, 65
 */
class DiscoverValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        val innRange = intArrayOf(6011, 622126, 622925, 644, 649, 65)
        val firstTwo: Int = parseIIN(creditCardNumberList, 2)
        val firstThree: Int = parseIIN(creditCardNumberList, 3)
        val firstFour: Int = parseIIN(creditCardNumberList, 4)
        val firstSix: Int = parseIIN(creditCardNumberList, 6)
        if (firstFour == innRange[0]) {
            hasAllowedIINRange = true
        }
        if (!hasAllowedIINRange) {
            for (i in innRange[1]..innRange[2]) {
                if (firstSix == i) {
                    hasAllowedIINRange = true
                    break
                }
            }
        }
        if (!hasAllowedIINRange) {
            for (i in innRange[3]..innRange[4]) {
                if (firstThree == i) {
                    hasAllowedIINRange = true
                    break
                }
            }
        }
        if (!hasAllowedIINRange && firstTwo == innRange[5]) {
            hasAllowedIINRange = true
        }
        return hasAllowedIINRange
    }
}