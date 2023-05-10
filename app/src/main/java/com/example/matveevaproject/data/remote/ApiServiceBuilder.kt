package com.example.matveevaproject.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceBuilder {

    const val BASE_URL = "https://dummyjson.com"

    val userAPI: UserApiInterface = createRetrofit().create(UserApiInterface::class.java)

    private fun createRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}