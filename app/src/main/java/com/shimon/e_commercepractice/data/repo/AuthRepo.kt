package com.shimon.e_commercepractice.data.repo

import com.shimon.e_commercepractice.Services.AuthService
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(private val service: AuthService) {

    suspend fun login(requestLogin: RequestLogin): Response<ResponseLogin> {
        return service.login(requestLogin)
    }

}