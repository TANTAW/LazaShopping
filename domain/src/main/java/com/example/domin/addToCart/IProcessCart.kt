package com.example.domin.addToCart

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface IProcessCart {
    fun addToCart(cartProductDto: CartProductDto): Flow<Resource<Unit>>
    fun updateCart(cartProductDto: CartProductDto): Flow<Resource<CartProductDto>>
    fun delete(cartProductDto: CartProductDto): Flow<Resource<Unit>>
    fun getAll(): Flow<Resource<List<CartDto>>>
}