package com.example.domin.addToCart

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

class CartUseCase(private val processCartRepository: IProcessCart) {
    fun add(productDto: CartProductDto): Flow<DataResult<Unit>> = processCartRepository.addToCart(productDto)
    fun getAllItems(): Flow<DataResult<List<CartDto>>> = processCartRepository.getAll()
    fun update(productDto: CartProductDto): Flow<DataResult<CartProductDto>> = processCartRepository.updateCart(productDto)
    fun delete(productDto: CartProductDto): Flow<DataResult<Unit>> = processCartRepository.delete(productDto)
}