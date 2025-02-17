package com.shimon.e_commercepractice.Services

import com.shimon.e_commercepractice.data.model.upload.uploadResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface UploadService {

    @Multipart
    @POST("files/upload")
   suspend fun upload(
      @Part file : MultipartBody.Part
   ) : Response<uploadResponse>

}