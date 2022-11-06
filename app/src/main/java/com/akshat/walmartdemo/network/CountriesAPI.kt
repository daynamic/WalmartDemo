package com.akshat.walmartdemo.network

import com.akshat.walmartdemo.BuildConfig
import com.akshat.walmartdemo.model.ResponseItem
import com.akshat.walmartdemo.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface CountriesAPI {

    @GET
    suspend fun getCountriesData(@Url url: String): Response<List<ResponseItem>>

    companion object {

        operator fun invoke(): CountriesAPI {

            //For logging network requests.
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
            val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.base_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(CountriesAPI::class.java)
        }
    }

}