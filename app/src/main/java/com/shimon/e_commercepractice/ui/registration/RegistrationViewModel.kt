package com.shimon.e_commercepractice.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shimon.e_commercepractice.data.model.Login.RequestLogin
import com.shimon.e_commercepractice.data.model.Login.ResponseLogin
import com.shimon.e_commercepractice.data.model.Register.RequestRegistration
import com.shimon.e_commercepractice.data.model.Register.ResponseRegistration
import com.shimon.e_commercepractice.data.repo.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {


    private var _response = MutableLiveData<Response<ResponseRegistration>>()
    var RegistrationResponse: LiveData<Response<ResponseRegistration>> = _response


    fun registration(requestRegistration: RequestRegistration) {
        viewModelScope.launch {
            _response.postValue(repo.registration(requestRegistration))
        }

    }

}