package com.example.domin.home

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

interface IBrandList {
    fun getBrandList(): Flow<DataResult<List<BrandDto>>>
}