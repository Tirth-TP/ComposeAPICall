package com.example.composeapicall.network

import com.example.composeapicall.model.UserResponse
import retrofit2.http.GET
import javax.inject.Singleton



@Singleton
interface ApiInterface {

    @GET("posts")
    suspend fun getUserData(): List<UserResponse>
}