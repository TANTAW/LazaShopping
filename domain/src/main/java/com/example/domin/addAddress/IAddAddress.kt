package com.example.domin.addAddress

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

interface IAddAddress {
    fun addAddress(
        name: String,
        country: String,
        city: String,
        phoneNumber: String,
        address: String,
        isConfirmed: Boolean
    ): Flow<DataResult<AddressDto>>
}
