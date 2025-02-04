package com.shimon.e_commercepractice.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.shimon.e_commercepractice.base.baseFragment
import com.shimon.e_commercepractice.databinding.FragmentProfileBinding


class ProfileFragment : baseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    val viewModel : ProfileViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.profile()
        viewModel.profileResponse.observe(viewLifecycleOwner){

        }


    }

}