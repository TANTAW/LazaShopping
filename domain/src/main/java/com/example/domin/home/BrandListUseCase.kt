package com.example.domin.home

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

class BrandListUseCase(private val brandList: IBrandList) {
    operator fun invoke(): Flow<Resource<List<BrandDto>>> = brandList.getBrandList()
}