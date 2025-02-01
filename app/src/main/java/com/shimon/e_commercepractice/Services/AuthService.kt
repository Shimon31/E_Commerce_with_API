package com.shimon.e_commercepractice.Services

import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.model.Register.RequestRegistration
import com.shimon.e_commercepractice.data.model.Register.ResponseRegistration
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
   suspend fun login(@Body requestLogin: RequestLogin) : Response<ResponseLogin>

    @POST("users/")
    suspend fun registration(@Body requestRegistration: RequestRegistration) : Response<ResponseRegistration>
}