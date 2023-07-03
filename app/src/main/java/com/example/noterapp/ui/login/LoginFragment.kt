package com.example.noterapp.ui.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.noterapp.R
import com.example.noterapp.databinding.FragmentLoginBinding
import com.example.noterapp.mvvm.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private var mGoogleSignInClient: GoogleSignInClient? = null
    private var loginViewModel: LoginViewModel? = null
    private val startForResultGoogle =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleGoogleSignInResult(task)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupGoogle()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnLoginIn.setOnClickListener {
            val intent = mGoogleSignInClient?.signInIntent
            startForResultGoogle.launch(intent)
        }

        return binding.root
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>){
        try {
            val account = completedTask.getResult(ApiException::class.java)

            Toast.makeText(requireContext(), account.toString(), Toast.LENGTH_SHORT).show()
        } catch (e: ApiException) {
            e.printStackTrace()
            //show dialog báo lỗi
        }
    }

    private fun setupGoogle() {
        val clientIn = "484696829746-urs9jood913pd6b19ggu2l48udp6at31.apps.googleusercontent.com"
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(clientIn)
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        mGoogleSignInClient?.signOut()
    }

}