package com.example.noterapp.mvvm

import androidx.lifecycle.ViewModel
import com.example.noterapp.dao.UserDao
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class LoginViewModel: ViewModel() {
    private val userDao: UserDao? = null

    fun addUser(account: GoogleSignInAccount){

    }
}