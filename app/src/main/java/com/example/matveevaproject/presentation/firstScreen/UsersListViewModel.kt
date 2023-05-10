package com.example.matveevaproject.presentation.firstScreen

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matveevaproject.data.remote.model.UserApiModel
import com.example.matveevaproject.domain.user.UserUseCase
import kotlinx.coroutines.launch

class UsersListViewModel : ViewModel() {

    private val userUseCase = UserUseCase
    val modelMutableLiveData = MutableLiveData<UserApiModel>()

    fun addUser(firstName: String?, email: String?, image: String?) {
        userUseCase.makeUser(firstName, email, image)
    }

    @SuppressLint("SuspiciousIndentation")
    fun getData() {
        viewModelScope.launch {
            try {
                val users = userUseCase.getUsers()
                modelMutableLiveData.postValue(users!!)
            } catch (ex: Exception){
                modelMutableLiveData.postValue(UserApiModel())
            }
        }
    }
}
