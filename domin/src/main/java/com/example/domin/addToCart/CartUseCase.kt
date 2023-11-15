package com.example.domin.addToCart

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class CartUseCase(private val processCartRepository: IProcessCart) {
    fun add(productDto: CartProductDto): Flow<Resource<Unit>> = processCartRepository.addToCart(productDto)
    fun getAllItems(): Flow<Resource<List<CartDto>>> = processCartRepository.getAll()
    fun update(productDto: CartProductDto): Flow<Resource<CartProductDto>> = processCartRepository.updateCart(productDto)
    fun delete(productDto: CartProductDto): Flow<Resource<Unit>> = processCartRepository.delete(productDto)
}