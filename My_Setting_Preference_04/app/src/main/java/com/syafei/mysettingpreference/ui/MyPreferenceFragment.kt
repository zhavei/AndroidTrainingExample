package com.syafei.mysettingpreference.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.CheckBoxPreference
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat
import com.syafei.mysettingpreference.R

class MyPreferenceFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var NAME: String
    private lateinit var EMAIL: String
    private lateinit var AGE: String
    private lateinit var PHONE: String
    private lateinit var LOVE: String

    private lateinit var namePreference: EditTextPreference
    private lateinit var emailPreference: EditTextPreference
    private lateinit var agePreference: EditTextPreference
    private lateinit var phonePreference: EditTextPreference
    private lateinit var lovePreference: CheckBoxPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)

        init()
        setSummaries()
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    private fun setSummaries() {
        val sh = preferenceManager.sharedPreferences
        namePreference.summary = sh.getString(NAME, DEFAULT_VALUE)
        emailPreference.summary = sh.getString(EMAIL, DEFAULT_VALUE)
        agePreference.summary = sh.getString(AGE, DEFAULT_VALUE)
        phonePreference.summary = sh.getString(PHONE, DEFAULT_VALUE)
        lovePreference.isChecked = sh.getBoolean(LOVE, false)
    }

    private fun init() {
        NAME = resources.getString(R.string.key_name)
        EMAIL = resources.getString(R.string.key_email)
        AGE = resources.getString(R.string.key_age)
        PHONE = resources.getString(R.string.key_phone)
        LOVE = resources.getString(R.string.key_love)

        namePreference = findPreference<EditTextPreference>(NAME) as EditTextPreference
        emailPreference = findPreference<EditTextPreference>(EMAIL) as EditTextPreference
        agePreference = findPreference<EditTextPreference>(AGE) as EditTextPreference
        phonePreference = findPreference<EditTextPreference>(PHONE) as EditTextPreference
        lovePreference = findPreference<CheckBoxPreference>(LOVE) as CheckBoxPreference

    }


    companion object {
        private const val DEFAULT_VALUE = "ORA Aada mase"
    }

    override fun onSharedPreferenceChanged(sharedPrefer: SharedPreferences, key: String?) {
        if (key == NAME) {
            namePreference.summary = sharedPrefer.getString(NAME, DEFAULT_VALUE)
        }

        if (key == EMAIL) {
            emailPreference.summary = sharedPrefer.getString(EMAIL, DEFAULT_VALUE)
        }

        if (key == AGE) {
            agePreference.summary = sharedPrefer.getString(AGE, DEFAULT_VALUE)
        }

        if (key == PHONE) {
            phonePreference.summary = sharedPrefer.getString(PHONE, DEFAULT_VALUE)
        }

        if (key == LOVE) {
            lovePreference.isChecked = sharedPrefer.getBoolean(LOVE, false)
        }
    }
}