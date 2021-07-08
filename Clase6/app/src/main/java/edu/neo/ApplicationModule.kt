package edu.neo

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module // tracking de las dependencias
class ApplicationModule(val application:Application) {


    @Provides // valor de retorno
    @Singleton // una sola instancai
    fun providerContext()=application



}