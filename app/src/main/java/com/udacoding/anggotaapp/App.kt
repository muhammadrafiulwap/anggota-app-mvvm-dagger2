package com.udacoding.anggotaapp

import com.udacoding.anggotaapp.Dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

//TODO 3 Tambahkan class App
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //TODO 6
        return DaggerAppComponent.builder().application(this).build()
    }

}


