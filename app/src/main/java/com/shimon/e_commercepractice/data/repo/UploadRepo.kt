package com.shimon.e_commercepractice.data.repo

import com.shimon.e_commercepractice.Services.AuthService
import com.shimon.e_commercepractice.Services.UploadService
import com.shimon.e_commercepractice.Services.UserService
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.model.Register.RequestRegistration
import com.shimon.e_commercepractice.data.model.Register.ResponseRegistration
import com.shimon.e_commercepractice.data.model.profile.ResponseProfile
import com.shimon.e_commercepractice.data.model.upload.uploadResponse
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class UploadRepo @Inject constructor(private val service: UploadService) {



    suspend fun upload(file : MultipartBody.Part): Response<uploadResponse> {
        return service.upload(file)
    }

}