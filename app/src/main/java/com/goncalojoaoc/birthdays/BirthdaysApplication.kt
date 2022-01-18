package com.goncalojoaoc.birthdays

import android.app.Application
import com.goncalojoaoc.birthdays.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BirthdaysApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BirthdaysApplication)
            modules(appModule)
        }
    }
}