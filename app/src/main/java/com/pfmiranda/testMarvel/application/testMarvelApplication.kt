package com.pfmiranda.testMarvel.application

import android.app.Application
import com.pfmiranda.testMarvel.api.networkModule
import com.pfmiranda.testMarvel.models.marvelRepositoryModule
import com.pfmiranda.testMarvel.viewModel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class testMarvelApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@testMarvelApplication)
            modules(listOf(marvelRepositoryModule,networkModule,viewModelModule))
        }
    }
}