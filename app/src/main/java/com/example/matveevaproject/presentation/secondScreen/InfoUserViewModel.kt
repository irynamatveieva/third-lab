package com.example.matveevaproject.presentation.secondScreen

import androidx.lifecycle.ViewModel
import com.example.matveevaproject.data.local.model.UserModel
import com.example.matveevaproject.domain.user.UserUseCase

class InfoUserViewModel : ViewModel() {

    private val userUseCase = UserUseCase

    fun getUser(): ArrayList<UserModel> {
        return userUseCase.getUser()
    }
}