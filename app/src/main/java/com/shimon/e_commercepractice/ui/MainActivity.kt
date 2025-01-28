package com.shimon.e_commercepractice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shimon.e_commercepractice.Services.AuthService
import com.shimon.e_commercepractice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}