package com.example.matveevaproject.data

import com.example.matveevaproject.data.remote.ApiServiceBuilder
import com.example.matveevaproject.data.remote.model.UserApiModel

object UserRepository {

    private val api = ApiServiceBuilder.userAPI

    suspend fun getUsers(): UserApiModel? {
        val response = api.getUsers()
        return if (response.isSuccessful && response.body() != null) {
            val body = response.body()
            body
        } else {
            null
        }
    }
}