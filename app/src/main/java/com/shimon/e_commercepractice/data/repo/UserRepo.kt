package com.shimon.e_commercepractice.data.repo

import com.shimon.e_commercepractice.Services.AuthService
import com.shimon.e_commercepractice.Services.UserService
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.model.Register.RequestRegistration
import com.shimon.e_commercepractice.data.model.Register.ResponseRegistration
import com.shimon.e_commercepractice.data.model.profile.ResponseProfile
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(private val service: UserService) {



    suspend fun profile(): Response<ResponseProfile> {
        return service.profile()
    }

}