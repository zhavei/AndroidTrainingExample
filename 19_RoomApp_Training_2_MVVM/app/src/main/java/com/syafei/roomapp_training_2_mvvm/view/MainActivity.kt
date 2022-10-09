package com.syafei.roomapp_training_2_mvvm.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.syafei.roomapp_training_2_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var loginViewModel: LoginViewModel
    lateinit var context: Context
    lateinit var mUserName: String
    lateinit var mPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        context = this@MainActivity

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btnAddLogin.setOnClickListener {
            mUserName = binding.txtUsername.text.toString().trim()
            mPassword = binding.txtPassword.text.toString().trim()

            if (mUserName.isEmpty()) {
                binding.txtUsername.error = "please enter the username"
            } else if (mPassword.isEmpty()) {
                binding.txtPassword.error = "please input the password"
            } else {
                loginViewModel.insertData(context, mUserName, mPassword)
                binding.lblInsertResponse.text = "dhuhul succesfully"
            }
        }

        binding.btnReadLogin.setOnClickListener{
            mUserName = binding.txtUsername.text.toString().trim()

            loginViewModel.getLoginDetails(context, mUserName)?.observe(this) {
                if (it == null) {
                    binding.lblReadResponse.text = "data not founde"
                    binding.lblUseraname.text = "_ _ _"
                    binding.lblPassword.text = "_ _ _"
                } else {
                    binding.lblUseraname.text = it.userName
                    binding.lblPassword.text = it.password

                    binding.lblReadResponse.text = "tojosh succesfully"
                }

            }


        }


    }
}