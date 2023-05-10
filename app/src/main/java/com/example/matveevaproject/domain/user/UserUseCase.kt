package com.example.matveevaproject.domain.user

import com.example.matveevaproject.data.UserRepository
import com.example.matveevaproject.data.local.model.UserDataBase
import com.example.matveevaproject.data.local.model.UserModel
import com.example.matveevaproject.data.remote.model.UserApiModel

object UserUseCase {
    private val userRepository = UserRepository
    private val UserData = UserDataBase()

    fun makeUser(image: String?, firstName: String?, email: String?) {
        UserData.makeUser(image, firstName, email)
    }

    fun getUser(): ArrayList<UserModel> {
        val userModels = ArrayList<UserModel>()
        userModels.add(UserData.userModel!!)
        return userModels
    }

    suspend fun getUsers(): UserApiModel? {
        return if (userRepository.getUsers() == null) {
            null
        } else {
            userRepository.getUsers()
        }
    }
}