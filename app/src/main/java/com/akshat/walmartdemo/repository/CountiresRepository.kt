package com.akshat.walmartdemo.repository

import com.akshat.walmartdemo.model.ResponseItem
import com.akshat.walmartdemo.network.CountriesAPI
import com.akshat.walmartdemo.utils.SafeAPIRequest

class CountiresRepository : SafeAPIRequest() {

    suspend fun getCountriesData(url: String): List<ResponseItem> {
        return apiRequest { CountriesAPI().getCountriesData(url) }
    }

}