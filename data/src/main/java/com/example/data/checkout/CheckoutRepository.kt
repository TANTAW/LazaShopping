package com.example.data.checkout

import com.example.common.Resource
import com.example.common.remote.BaseRemoteDataSource
import com.example.common.remote.ResponseStatus
import com.example.common.remote.StatusResults
import com.example.data.checkout.models.CardModel
import com.example.data.checkout.models.CartProductModel
import com.example.data.checkout.models.CartRequest
import com.example.data.checkout.models.OrderInfoModel
import com.example.data.home.models.ProductModel
import com.example.data.home.models.ReviewModel
import com.example.domin.addToCart.CartDto
import com.example.domin.checkout.ICheckout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class CheckoutRepository(private val checkoutApi: CheckoutApi) : ICheckout, BaseRemoteDataSource() {

    override fun checkout(cart: CartDto): Flow<Resource<ResponseStatus>> {
        val cartItemList = cart.items.map {
            val reviewsList =
                it.productDto.reviews.map { review ->
                    ReviewModel(
                        review.name,
                        review.date,
                        review.rate,
                        review.description
                    )
                }

            CartProductModel(
                ProductModel(
                    it.productDto.title,
                    it.productDto.price,
                    it.productDto.sizeList,
                    it.productDto.description,
                    it.productDto.fullImage,
                    it.productDto.smallImageList,
                    it.productDto.totalReview,
                    reviewsList
                ),
                it.productCount
            )
        }

        val card = CardModel(
            cart.card.type,
            cart.card.cardHolder,
            cart.card.cardNumber,
            cart.card.expiryDate,
            cart.card.cvv,
            cart.card.isConfirmed
        )

        val calculations = OrderInfoModel(
            cart.calculations.subtotal,
            cart.calculations.shippingCost,
            cart.calculations.total
        )

        val cartRequest = CartRequest(
            items = cartItemList,
            address = cart.address,
            card = card,
            calculations = calculations
        )

        return safeApiCall {
            checkoutApi.checkout(cartRequest)
        }.map {
            when (it) {
                is Resource.Loading -> Resource.Loading(data = true)
                is Resource.Error -> Resource.Error(errorTypes = it.errorTypes)
                is Resource.Success -> Resource.Success(data = it.data)
            }
        }
    }
}