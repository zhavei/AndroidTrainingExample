package com.syafei.mysharedpreferences

import android.content.Context

internal class UserPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val LOVE_MU = "islove"
    }

    private val preference = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        val editor = preference.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(PHONE_NUMBER, value.phoneNUmber)
        editor.putBoolean(LOVE_MU, value.isLove)
        editor.apply()
    }

    fun getUser(): UserModel {
        val model = UserModel()
        model.name = preference.getString(NAME, "")
        model.email = preference.getString(EMAIL, "")
        model.age = preference.getInt(AGE, 0)
        model.phoneNUmber = preference.getString(PHONE_NUMBER, "")
        model.isLove = preference.getBoolean(LOVE_MU, false)

        return model
    }

}