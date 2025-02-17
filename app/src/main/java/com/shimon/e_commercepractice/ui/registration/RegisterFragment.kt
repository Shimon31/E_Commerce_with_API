package com.shimon.e_commercepractice.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.shimon.e_commercepractice.R
import com.shimon.e_commercepractice.base.baseFragment
import com.shimon.e_commercepractice.data.model.Register.RequestRegistration
import com.shimon.e_commercepractice.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : baseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

   private val viewmodel : RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.RegistrationResponse.observe(viewLifecycleOwner){

            if (it.isSuccessful){

                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

            }


        }

        binding.registerBtn.setOnClickListener {

            var name = binding.nameET.text.toString().trim()
            var email = binding.emailET.text.toString().trim()
            var password = binding.passwordET.text.toString().trim()
            var imageAvatar ="https://media.licdn.com/dms/image/v2/D5603AQErtE23hVt_9g/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1725974334692?e=2147483647&v=beta&t=wf3tC9QCVFXiThXP3zq9UQhQ4ColGEq05-wgnqbF0fg"

            val requestRegister = RequestRegistration(
                avatar = imageAvatar,
                email = email,
                name = name,
                password = password
            )

            viewmodel.registration(requestRegister)
        }


        binding.SignInBtn.setOnClickListener {

            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }


}