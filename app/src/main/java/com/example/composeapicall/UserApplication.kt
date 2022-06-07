package com.example.composeapicall

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Tirth Patel.
 */
@HiltAndroidApp
class UserApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}