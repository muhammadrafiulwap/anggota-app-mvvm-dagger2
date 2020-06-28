package com.udacoding.anggotaapp.Dagger

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.udacoding.anggotaapp.Repo.Repository
import com.udacoding.anggotaapp.ViewModel.ViewModelMainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//TODO 10 Add Class AppModule dengan anotasi @Module
@Module
class AppModule {

    //TODO 11
    @Singleton
    @Provides
    fun provideContext(application: Application): Context{
        return application.applicationContext
    }

    //TODO 14
    @Singleton
    @Provides
    fun provideRepository(): Repository = Repository()

}

