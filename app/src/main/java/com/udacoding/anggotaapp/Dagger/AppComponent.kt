package com.udacoding.anggotaapp.Dagger

import android.app.Application
import com.udacoding.anggotaapp.App
import com.udacoding.anggotaapp.Dagger.ViewModels.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//TODO 5 Tambahkan interface AppComponent, setelah menambahkankan code, silahkan rebuild
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        //TODO 8 Daftarkan semua class yang mempunyai anotasi @Module
        ActivityBuildersModule::class,
        AppModule::class,
        //TODO 18 add ViewModelFactoryModule
        ViewModelFactoryModule::class
    ]
)
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): AppComponent

    }

}




