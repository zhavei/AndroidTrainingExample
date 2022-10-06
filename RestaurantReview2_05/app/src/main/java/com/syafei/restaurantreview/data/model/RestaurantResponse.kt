package com.syafei.restaurantreview.data.model


import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("restaurant")
    val restaurant: Restaurant
)

data class Restaurant(
    @SerializedName("customerReviews")
    val customerReviews: List<CustomerReview>,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("pictureId")
    val pictureId: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("rating")
    val rating: Double
)

data class  CustomerReview(
    @SerializedName("date")
    val date: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("review")
    val review: String
)

data class ReviewResponse(

    @field:SerializedName("customerReviews")
    val customerReviews: List<CustomerReview>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)