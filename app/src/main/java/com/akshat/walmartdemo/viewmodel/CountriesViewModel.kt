package com.akshat.walmartdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshat.walmartdemo.model.ResponseItem
import com.akshat.walmartdemo.repository.CountiresRepository
import com.akshat.walmartdemo.utils.ApiExceptions
import com.akshat.walmartdemo.utils.Constants
import com.akshat.walmartdemo.utils.Coroutines

class CountriesViewModel(
    private val repository: CountiresRepository
) : ViewModel() {

    //var authListener: ServiceHomeRecyclerViewClickListener? = null
    private val _providedData = MutableLiveData<List<ResponseItem>>()
    val providedData: LiveData<List<ResponseItem>>
        get() = _providedData


    fun getCountriesData(){
        Coroutines.main {
            try {
                val url = Constants.endPoint
                val authResponse = repository.getCountriesData(url)
                if (authResponse.response!=null) {
                    _providedData.value = authResponse.response
                    return@main
                }
            } catch (e: ApiExceptions) {
             //   authListener?.onFailure(e.message!!)
            }
        }
    }

}