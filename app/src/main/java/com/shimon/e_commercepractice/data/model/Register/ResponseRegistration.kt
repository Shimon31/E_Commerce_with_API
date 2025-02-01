package com.shimon.e_commercepractice.data.model.Register

data class ResponseRegistration(
    val error: String,
    val message: List<String>,
    val statusCode: Int
)