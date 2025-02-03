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
            var avatar =
                "https://www.google.com/imgres?q=sadek%20bhuiya%20shimon&imgurl=https%3A%2F%2Fcricheroes-media-mumbai.s3.ap-south-1.amazonaws.com%2Fuser_profile%2F1668174516162_kejQFXsUR2x4.jpg%3Fwidth%3D3840%26quality%3D75%26format%3Dauto&imgrefurl=https%3A%2F%2Fcricheroes.com%2Fscorecard%2F4759345%2Fyksg-1-short-pitch-cricket-turnament-2022%2Fnb-2-vs-nb-10%2Fmvp&docid=UKONeORs3rLmBM&tbnid=a-mw2mNw7gNXQM&vet=12ahUKEwj63KDR3qSLAxVph68BHfr4E_AQM3oECG0QAA..i&w=1080&h=1080&hcb=2&itg=1&ved=2ahUKEwj63KDR3qSLAxVph68BHfr4E_AQM3oECG0QAA"

            val requestRegister = RequestRegistration(
                avatar = avatar,
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