package com.syafei.restaurantreview.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syafei.restaurantreview.data.api.ApiConfig
import com.syafei.restaurantreview.data.model.CustomerReview
import com.syafei.restaurantreview.data.model.Restaurant
import com.syafei.restaurantreview.data.model.RestaurantResponse
import com.syafei.restaurantreview.data.model.ReviewResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _restourant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restourant

    private val _listReview = MutableLiveData<List<CustomerReview>>()
    val listReview: LiveData<List<CustomerReview>> = _listReview

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> = _showLoading

    private val _snackBarr = MutableLiveData<Event<String>>()
    val snackbar: LiveData<Event<String>> = _snackBarr

    companion object {

        const val TAG = "MainViewMOdel_"
        const val RESTAURANT_ID = "ygewwl55ktckfw1e867"
    }

    init {
        findRestourant()

    }

    private fun findRestourant() {
        _showLoading.value = true
        val client = ApiConfig.getApiService().getRestourant(RESTAURANT_ID)
        client.enqueue(object : Callback<RestaurantResponse> {
            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                _showLoading.value = false
                if (response.isSuccessful) {
                    val responeBody = response.body()
                    if (responeBody != null) {
                        _restourant.value = response.body()?.restaurant
                        _listReview.value = response.body()?.restaurant?.customerReviews
                    }
                } else {
                    Log.e(TAG, "onfailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                _showLoading.value = false
                Log.e(TAG, "onfailure: ${t.message}")
            }

        })
    }

    fun postReview(reviewResponse: String) {
        _showLoading.value = true
        val client =
            ApiConfig.getApiService().postReview(RESTAURANT_ID, "duck black", reviewResponse)
        client.enqueue(object : Callback<ReviewResponse> {
            override fun onResponse(
                call: Call<ReviewResponse>,
                response: Response<ReviewResponse>
            ) {
                _showLoading.value = false
                val responeBody = response.body()
                if (response.isSuccessful && responeBody != null) {
                    _listReview.value = responeBody.customerReviews
                    _snackBarr.value = Event(response.body()?.message.toString())
                } else {
                    Log.e(TAG, "onfailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                _showLoading.value = false
                Log.e(TAG, "onfailure: ${t.message}")
            }

        })
    }

}
