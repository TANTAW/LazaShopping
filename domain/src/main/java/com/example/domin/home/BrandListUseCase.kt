package com.example.domin.home

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

class BrandListUseCase(private val brandList: IBrandList) {
    operator fun invoke(): Flow<DataResult<List<BrandDto>>> = brandList.getBrandList()
}