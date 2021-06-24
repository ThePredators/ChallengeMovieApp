package com.example.movieapp

import android.app.Application
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.ENABLE_DEBUG) {
            setupTimber()
//            setupStetho()
            setupCustomActivityOnCrash()
        }
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun setupCustomActivityOnCrash() {
        CaocConfig.Builder.create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
            .apply()
    }
}