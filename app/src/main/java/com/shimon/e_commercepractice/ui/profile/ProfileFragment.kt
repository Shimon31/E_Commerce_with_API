package com.shimon.e_commercepractice.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import coil3.load
import coil3.request.error
import coil3.request.placeholder
import com.shimon.e_commercepractice.R
import com.shimon.e_commercepractice.base.baseFragment
import com.shimon.e_commercepractice.databinding.FragmentProfileBinding
import com.shimon.e_commercepractice.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : baseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

   private val viewModel: ProfileViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.profileResponse.observe(viewLifecycleOwner) {

            if (!it.isSuccessful) return@observe


            binding.apply {

                it.body()?.let { profile ->

                    name.text = profile.name
                    email.text = profile.email
                    role.text = profile.role
                    profileIV.load(profile.avatar)

                }


            }


        }

    }

}