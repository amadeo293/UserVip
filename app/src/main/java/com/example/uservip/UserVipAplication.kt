package com.example.uservip

import android.app.Application

class UserVipAplication: Application() {

    companion object{
        lateinit var pref: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        pref = Prefs(applicationContext)
    }
}