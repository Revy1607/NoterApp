package com.example.noterapp.mvvm

import com.example.noterapp.dao.UserDao
import com.example.noterapp.model.User

class LoginRepository(val userdao: UserDao) {

    suspend fun addUser(user: User){
        userdao.addUser(user)
    }
}