package com.bangkit.tursik.ui.splash

import android.content.SharedPreferences
import android.content.Context

class SessionManager(private val context: Context) {
    private val prefName = "Session"
    private val isLoggedInKey = "isLoggedIn"

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(isLoggedInKey, false)
        set(value) = editor.putBoolean(isLoggedInKey, value).apply()

    fun logout() {
        sharedPreferences.edit().clear().apply()
    }
}