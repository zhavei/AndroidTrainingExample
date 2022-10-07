package com.syafei.mysharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userModel: UserModel
    private lateinit var mUserPreference: UserPreference

    private var isPreferenceEmpty = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "My USer Preference"

        mUserPreference = UserPreference(this)

        showExistingPreference()

    }

    private fun showExistingPreference() {
        userModel = mUserPreference.getUser()
        populateView(userModel)
        chekForm(userModel)
    }

    private fun chekForm(userModel: UserModel) {
        when {
            userModel.name.toString().isNotEmpty() -> {
                binding.btnSave.text = getString(R.string.change)
                isPreferenceEmpty = false
            }
            else -> {
                binding.btnSave.text = getString(R.string.save)
                isPreferenceEmpty = true
            }

        }
    }

    private fun populateView(userModel: UserModel) {
        binding.tvName.text =
            if (userModel.name.toString().isEmpty()) "tidak ada" else userModel.name
        binding.tvAge.text =
            if (userModel.age.toString().isEmpty()) "tidak ada" else userModel.age.toString()
        binding.tvIsLoveMu.text = if (userModel.isLove) "ya" else "tidak"
        binding.tvEmail.text =
            if (userModel.email.toString().isEmpty()) "tidak ada" else userModel.email

    }


}