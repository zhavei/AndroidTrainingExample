package com.syafei.restaurantreview

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.syafei.restaurantreview.data.model.CustomerReview
import com.syafei.restaurantreview.data.model.Restaurant
import com.syafei.restaurantreview.databinding.ActivityMainBinding
import com.syafei.restaurantreview.ui.MainViewModel
import com.syafei.restaurantreview.ui.ReviewAdapter

class MainActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)

        //with no ktx libs
        /*val mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)*/

        mainViewModel.restaurant.observe(this) { restaurant ->
            setRestaurantData(restaurant)
        }

        mainViewModel.listReview.observe(this) { listReview ->
            setReviewData(listReview)
        }

        mainViewModel.showLoading.observe(this) { loading ->
            showLoading(loading)
        }


        binding.btnSend.setOnClickListener { view ->
            mainViewModel.postReview(binding.edReview.text.toString())
            //postReview(binding.edReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        mainViewModel.snackbar.observe(this) { snack ->
            snack.getContentIfNotHandled()?.let { snackBarr ->
                Snackbar.make(window.decorView.rootView, snackBarr, Snackbar.LENGTH_SHORT).show()
            }
        }

    }


    private fun setReviewData(customerReviews: List<CustomerReview>) {
        val listReview = ArrayList<String>()
        for (review in customerReviews) {
            listReview.add(
                """
                    ${review.review}
                    - ${review.name}
                    tanggal - ${review.date}
                """.trimIndent()
            )
        }
        val adapter = ReviewAdapter(listReview)
        binding.rvReview.adapter = adapter
        binding.edReview.setText("")
    }

    private fun setRestaurantData(restaurant: Restaurant) {
        binding.tvTitle.text = restaurant.name
        binding.tvDescription.text = restaurant.description
        binding.tvCity.text = restaurant.city
        binding.tvRating.text = restaurant.rating.toString()

        Glide.with(this@MainActivity)
            .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
            .into(binding.ivPicture)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}