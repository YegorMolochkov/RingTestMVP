package com.molochkov.ringtestmvp.core.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitServiceProvider(baseUrl: String) : ServiceProvider {


    private val retrofit: Retrofit

    init {
        val okHttpBuilder = OkHttpClient.Builder()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpBuilder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

    override fun <S> createService(serviceClass: Class<S>): S = retrofit.create(serviceClass)
}