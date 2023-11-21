package com.example.domin.addAddress

import androidx.core.text.isDigitsOnly
import com.example.common.Resource
import com.example.common.TextUI
import com.example.common.remote.ErrorTypes
import com.example.domin.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AddAddressUseCase(private val addAddress: IAddAddress) {
    operator fun invoke(
        name: String,
        country: String,
        city: String,
        phoneNumber: String,
        address: String,
    ): Flow<Resource<AddressDto>> {
        if (name.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_username))))
        if (country.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_country))))
        if (city.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_city))))
        if (phoneNumber.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_phone_number))))
        if (phoneNumber.isDigitsOnly())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.valid_phone))))
        if (address.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_address))))
        return addAddress.addAddress(name, country, city, phoneNumber, address)
    }

}