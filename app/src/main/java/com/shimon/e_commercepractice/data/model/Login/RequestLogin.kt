package com.shimon.e_commercepractice.data.model.Login


import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("password")
    var password: String? = null
)