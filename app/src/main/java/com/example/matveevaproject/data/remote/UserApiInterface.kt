package com.example.matveevaproject.data.remote

import com.example.matveevaproject.data.remote.model.UserApiModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiInterface {
    @GET("/users")
    suspend fun getUsers(): Response<UserApiModel>
}