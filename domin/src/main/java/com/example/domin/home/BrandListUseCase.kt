package com.example.domin.home

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class BrandListUseCase(private val brandListRepository: IBrandList) {
    operator fun invoke(): Flow<Resource<List<BrandDto>>> = brandListRepository.getBrandList()
}