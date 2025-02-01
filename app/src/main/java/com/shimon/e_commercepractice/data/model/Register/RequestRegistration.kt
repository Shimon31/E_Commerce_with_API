package com.shimon.e_commercepractice.data.model.Register

data class RequestRegistration(
    val avatar: String,
    val email: String,
    val name: String,
    val password: String
)