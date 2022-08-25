package org.kredent.app.ui.application

import android.app.Application
import co.touchlab.kermit.Logger
import co.touchlab.kermit.platformLogWriter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KredentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.setLogWriters(platformLogWriter())
    }
}
