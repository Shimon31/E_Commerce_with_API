package com.shimon.e_commercepractice.data.model.Register

data class ResponseLogin(
    val error: String,
    val message: List<String>,
    val statusCode: Int
)