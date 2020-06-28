package com.udacoding.anggotaapp.Repo

import com.udacoding.anggotaapp.Config.NetworkModule
import com.udacoding.anggotaapp.Model.getdata.ResponseGetData
import dagger.Module
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

class Repository {

    fun getData(responHandler: (ResponseGetData) -> Unit, errorHandler: (Throwable) -> Unit) {

        NetworkModule.service().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            },{
                errorHandler(it)
            })

    }

}