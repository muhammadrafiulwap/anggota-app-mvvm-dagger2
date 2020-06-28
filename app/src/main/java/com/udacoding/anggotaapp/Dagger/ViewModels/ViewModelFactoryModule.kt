package com.udacoding.anggotaapp.Dagger.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacoding.anggotaapp.ViewModel.ViewModelMainActivity
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

//TODO 17 add new class ViewModelFactoryModule
@Module
abstract class ViewModelFactoryModule {

    //TODO 18
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    //TODO 19
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory) : ViewModelProvider.Factory

    //TODO 20
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelMainActivity::class)
    abstract fun bindViewModelMainActivity(viewModelMainActivity: ViewModelMainActivity): ViewModel

}