package com.example.dotify_kotlin

import android.app.Application
import com.example.dotify_kotlin.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application(){

    override fun onCreate() {
        
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(myModule)
        }

    }


}