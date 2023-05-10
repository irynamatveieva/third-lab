package com.example.matveevaproject.data.local.model

class UserDataBase {

    var userModel: UserModel? = null

    fun makeUser(image: String?, firstName: String?, email: String?) {
        userModel = UserModel(image,firstName,email)
    }
}