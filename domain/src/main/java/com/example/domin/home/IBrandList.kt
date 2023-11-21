package com.example.domin.home

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface IBrandList {
    fun getBrandList(): Flow<Resource<List<BrandDto>>>
}