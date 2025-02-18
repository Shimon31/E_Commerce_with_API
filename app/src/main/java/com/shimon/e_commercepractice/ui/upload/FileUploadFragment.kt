package com.shimon.e_commercepractice.ui.upload

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.load
import com.github.dhaval2404.imagepicker.ImagePicker
import com.shimon.e_commercepractice.base.baseFragment
import com.shimon.e_commercepractice.databinding.FragmentFileUploadBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

@AndroidEntryPoint
class FileUploadFragment :
    baseFragment<FragmentFileUploadBinding>(FragmentFileUploadBinding::inflate) {

    private val viewModel: UploadViewModel by viewModels()

    private var fileUri: Uri? = null

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {
                    //Image Uri will not be null for RESULT_OK
                    fileUri = data?.data!!

                    binding.uploadIV.setImageURI(fileUri)
                    binding.uploadImage.visibility = View.VISIBLE

                }
                ImagePicker.RESULT_ERROR -> {
                    Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT)
                        .show()
                    binding.uploadImage.visibility = View.GONE
                }
                else -> {
                    Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
                    binding.uploadImage.visibility = View.GONE
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.UploadResponse.observe(viewLifecycleOwner) {

            if (it.isSuccessful) {

                binding.uploadPreview.load(it.body()?.location)

            }

        }

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

        binding.uploadImage.setOnClickListener {

            fileUri?.let { fileUri ->
                uploadFile(fileUri)
            }

        }
    }

    private fun uploadFile(it: Uri) {

        val fileDir = requireActivity().filesDir
        val file = File(fileDir,"user_${System.currentTimeMillis()}.png")

        val inputStream = requireActivity().contentResolver.openInputStream(it)

        val outPutStream = FileOutputStream(file)

        inputStream?.copyTo(outPutStream)

        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())

        val part = MultipartBody.Part.createFormData("file",file.name,requestBody)

        viewModel.upload(part)

        inputStream?.close()
        outPutStream.close()


    }

}