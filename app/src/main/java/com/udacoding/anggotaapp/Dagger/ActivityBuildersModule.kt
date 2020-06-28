package com.udacoding.anggotaapp.Dagger

import com.udacoding.anggotaapp.View.MainActivity
import com.udacoding.anggotaapp.ViewModel.ViewModelMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

//TODO 7
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun constributeMainActivity(): MainActivity

}


