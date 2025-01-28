package com.shimon.e_commercepractice.Services

import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin) : Response<RequestLogin>

}