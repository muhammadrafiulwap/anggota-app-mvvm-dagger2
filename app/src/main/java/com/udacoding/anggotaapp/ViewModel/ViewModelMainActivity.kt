package com.udacoding.anggotaapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacoding.anggotaapp.Model.getdata.ResponseGetData
import com.udacoding.anggotaapp.Repo.Repository
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton


//TODO 15 @Inject constructor
class ViewModelMainActivity @Inject constructor(private val repository: Repository) : ViewModel() {

    var responseData = MutableLiveData<ResponseGetData>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getListData() {

        isLoading.value = true

        repository.getData({
            responseData.value = it
            isLoading.value = false
        }, {
            isError.value = it
            isLoading.value = false
        })

    }


}