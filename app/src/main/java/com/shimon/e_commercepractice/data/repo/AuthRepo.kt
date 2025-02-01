package com.shimon.e_commercepractice.data.repo

import com.shimon.e_commercepractice.Services.AuthService
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.model.Register.RequestRegistration
import com.shimon.e_commercepractice.data.model.Register.ResponseRegistration
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(private val service: AuthService) {

    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin> {
        return service.login(requestLogin)
    }

    suspend fun registration(requestRegistration: RequestRegistration): Response<ResponseRegistration> {
        return service.registration(requestRegistration)
    }

}