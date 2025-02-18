package com.shimon.e_commercepractice.ui.upload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shimon.e_commercepractice.data.model.upload.uploadResponse
import com.shimon.e_commercepractice.data.repo.UploadRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UploadViewModel @Inject constructor(private val repo: UploadRepo) : ViewModel() {


    private var _response = MutableLiveData<Response<uploadResponse>>()
    var UploadResponse: LiveData<Response<uploadResponse>> = _response


    fun upload(file : MultipartBody.Part) {
        viewModelScope.launch {
            _response.postValue(repo.upload(file))
        }

    }

}