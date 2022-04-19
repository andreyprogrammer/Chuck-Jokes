package com.example.andreymerkurev.chuckjokes

import android.app.Application
import com.example.andreymerkurev.chuckjokes.di.AppComponent
import com.example.andreymerkurev.chuckjokes.di.AppModule
import com.example.andreymerkurev.chuckjokes.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }
}