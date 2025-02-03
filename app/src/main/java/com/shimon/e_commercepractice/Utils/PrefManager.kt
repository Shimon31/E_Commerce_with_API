package com.shimon.e_commercepractice.Utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefManager @Inject constructor(@ApplicationContext context: Context) {

    private val pref = context.getSharedPreferences("app=pref", Context.MODE_PRIVATE)

    fun setPref(key: String, value: String) {

        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()

    }

    fun getPref(key: String): String {

        val prefValue = pref.getString(key, "")
        return prefValue.toString()

    }
}