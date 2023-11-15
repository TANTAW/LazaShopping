package com.example.domin.addToCart

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

interface IProcessCart {
    fun addToCart(cartProductDto: CartProductDto): Flow<DataResult<Unit>>
    fun updateCart(cartProductDto: CartProductDto): Flow<DataResult<CartProductDto>>
    fun delete(cartProductDto: CartProductDto): Flow<DataResult<Unit>>
    fun getAll(): Flow<DataResult<List<CartDto>>>
}