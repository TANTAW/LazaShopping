package com.example.domin.addAddress

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class AddAddressUseCase(private val addAddressRepository: IAddAddress) {
    operator fun invoke(
        name: String,
        country: String,
        city: String,
        phoneNumber: String,
        address: String,
        isConfirmed: Boolean
    ): Flow<Resource<AddressDto>> = addAddressRepository.addAddress(name, country, city, phoneNumber, address, isConfirmed)
}