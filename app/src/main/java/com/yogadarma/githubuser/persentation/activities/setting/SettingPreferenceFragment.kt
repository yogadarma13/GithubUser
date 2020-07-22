package com.yogadarma.githubuser.persentation.activities.setting

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.task.AlarmReceiver

class SettingPreferenceFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var languagePreference: Preference
    private lateinit var reminderPreference: SwitchPreference
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        init()
        setupListener()
    }

    private fun init() {
        languagePreference = findPreference<Preference>("language") as Preference
        reminderPreference = findPreference<SwitchPreference>("reminder") as SwitchPreference

        alarmReceiver = AlarmReceiver()
    }

    private fun setupListener() {
        languagePreference.setOnPreferenceClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))

            true
        }
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        if (key == "reminder") {
            val statusReminder = sharedPreferences.getBoolean("reminder", false)

            if (statusReminder) {
                alarmReceiver.setDailyReminderOn(context, "09:00")
            } else {
                alarmReceiver.setDailyReminderOff(context)
            }
        }
    }

}