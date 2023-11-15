package com.example.domin.addAddress

import com.ahmed.a.habib.common.DataResult
import kotlinx.coroutines.flow.Flow

class AddAddressUseCase(private val addAddress: IAddAddress) {
    operator fun invoke(
        name: String,
        country: String,
        city: String,
        phoneNumber: String,
        address: String,
        isConfirmed: Boolean
    ): Flow<DataResult<AddressDto>> =
        addAddress.addAddress(name, country, city, phoneNumber, address, isConfirmed)
}