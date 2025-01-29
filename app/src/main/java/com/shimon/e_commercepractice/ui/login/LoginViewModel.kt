package com.shimon.e_commercepractice.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {


    private var _response = MutableLiveData<Response<ResponseLogin>>()
    var LoginResponse: LiveData<Response<ResponseLogin>> = _response


    fun login(requestLogin: RequestLogin) {
        viewModelScope.launch {
            _response.postValue(repo.login(requestLogin))
        }

    }

}