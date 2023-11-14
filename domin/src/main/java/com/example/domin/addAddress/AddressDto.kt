package com.example.domin.addAddress

data class AddressDto(
    val name: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
    val address: String,
    val isConfirmed: Boolean
)
