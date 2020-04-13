package com.anil.gctestmodule

import android.app.Application
import com.anil.gctestmodule.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GCApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GCApplication)
            modules(viewModelModule)
        }
    }
}