package edu.neo

import android.app.Application
import dagger.internal.DaggerCollections

class App : Application() {


   private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().
        applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    fun getApplicationComponent():ApplicationComponent
    {
        return component
    }
}