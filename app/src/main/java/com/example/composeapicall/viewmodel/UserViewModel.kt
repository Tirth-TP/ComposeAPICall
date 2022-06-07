package com.example.composeapicall.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeapicall.model.UserResponse
import com.example.composeapicall.repository.UserRepository
import com.example.composeapicall.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Tirth Patel.
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepositor: UserRepository
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private val _getUserData: MutableLiveData<List<UserResponse>> = MutableLiveData<List<UserResponse>>()
    var getUserData: LiveData<List<UserResponse>> = _getUserData

    suspend fun getUserData(): Resource<List<UserResponse>> {
        val result = userRepositor.getUserResponse()
        if (result is Resource.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!
        }

        return result
    }
}