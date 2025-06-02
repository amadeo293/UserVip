package com.example.uservip

import android.content.Context

class Prefs(context: Context) {

    private val SHARED_NAME = "Mydtb"
    private val SHARED_USER_NAME = "username"
    private val SHARED_VIP = "vip"
    private val storage = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    fun saveName(name: String) {
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVIP(vip: Boolean) {
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    fun getName(): String {
        return storage.getString(SHARED_USER_NAME, "") ?: ""
    }

    fun getVIP(): Boolean {
        return storage.getBoolean(SHARED_VIP, false)
    }

    fun wipe() {
        storage.edit().clear().apply()
    }
}
