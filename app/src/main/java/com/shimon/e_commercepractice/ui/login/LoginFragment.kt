package com.shimon.e_commercepractice.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.key
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.shimon.e_commercepractice.R
import com.shimon.e_commercepractice.Utils.PrefManager
import com.shimon.e_commercepractice.Utils.key
import com.shimon.e_commercepractice.base.baseFragment
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : baseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var prefManager: PrefManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.LoginResponse.observe(viewLifecycleOwner) {

            if (it.isSuccessful) {

                prefManager.setPref(key.Access_Token,it.body()?.access_token!!)
                prefManager.setPref(key.Refresh_Token,it.body()?.refresh_token!!)

               // findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
            }


        }

        binding.createAnAccountTV.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)

        }

        binding.loginBtn.setOnClickListener {

            val email = binding.emailET.text.toString()
            val password = binding.passwordET.text.toString()


            handleLogin(email, password)

        }

    }

    private fun handleLogin(email: String, password: String) {

        val requestLogin = RequestLogin(email = email, password = password)

        viewModel.login(requestLogin)
    }

}