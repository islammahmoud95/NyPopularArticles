package com.example.nypopulararticle

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
@HiltAndroidApp
class NYArticalApp : Application() {
    companion object {
        lateinit var application: NYArticalApp
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        Timber.plant(Timber.DebugTree())

    }
}