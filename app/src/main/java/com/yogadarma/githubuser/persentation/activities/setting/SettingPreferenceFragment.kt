package com.yogadarma.githubuser.persentation.activities.setting

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.yogadarma.githubuser.R

class SettingPreferenceFragment: PreferenceFragmentCompat() {

    private lateinit var languagePreference: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        init()
        setupListener()
    }

    private fun init() {
        languagePreference = findPreference<Preference>("language") as Preference
    }

    private fun setupListener() {
        languagePreference.setOnPreferenceClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))

            true
        }
    }

//    override fun onResume() {
//        super.onResume()
//        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
//    }

//    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
//        if (key == "language") {
//            languagePreference.seto
//            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
//        }
//    }

}