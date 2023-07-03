package com.example.noterapp.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginFactoryViewModel(private val loginRepository: LoginRepository) : ViewModelProvider.Factory{

    // boilerplate code

//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
//            return LoginViewModel(loginRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel Class")
//    }
}