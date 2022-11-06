package com.akshat.walmartdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshat.walmartdemo.repository.CountiresRepository

@Suppress("UNCHECKED_CAST")
class CountriesViewModelFactory(
    private val repository: CountiresRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountriesViewModel(repository) as T
    }
}