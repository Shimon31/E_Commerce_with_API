package com.shimon.e_commercepractice.ui.upload

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.github.dhaval2404.imagepicker.ImagePicker
import com.shimon.e_commercepractice.base.baseFragment
import com.shimon.e_commercepractice.databinding.FragmentFileUploadBinding


class FileUploadFragment :
    baseFragment<FragmentFileUploadBinding>(FragmentFileUploadBinding::inflate) {

    private var fileUri: Uri? = null

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                fileUri = data?.data!!

                binding.uploadIV.setImageURI(fileUri)
                binding.uploadImage.visibility = View.VISIBLE

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pickAnIamage.setOnClickListener {
            ImagePicker.with(this)
                .compress(512)         //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    512,
                    512
                )  //Final image resolution will be less than 1080 x 1080(Optional)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }

        }
        binding.uploadIV.setOnClickListener {

            fileUri?.let { fileUri->
                uploadFile(fileUri)
            }

        }
    }

    private fun uploadFile(fileUri: Uri) {



    }

}