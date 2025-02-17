package com.shimon.e_commercepractice.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shimon.e_commercepractice.Services.UserService
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.model.profile.ResponseProfile
import com.shimon.e_commercepractice.data.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: UserService) : ViewModel() {


    private var _response = MutableLiveData<Response<ResponseProfile>>()
    var profileResponse: LiveData<Response<ResponseProfile>> = _response


    init {
        profile()
    }
   private fun profile() {
        viewModelScope.launch {
            _response.postValue(repo.profile())
        }

    }

}