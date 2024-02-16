package com.mleiva.loginretrofit.retrofit

import com.mleiva.loginretrofit.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit.retrofit
 * Creted by: Marcelo Leiva on 15-02-2024 at 21:20
 ***/
interface LoginService {

    @Headers("Content-Type: application/json")
    @POST(Constants.API_PATH + Constants.LOGIN_PATH)
    fun login(@Body data: UserInfo): Call<LoginResponse>

    @POST(Constants.API_PATH + Constants.LOGIN_PATH)
    suspend fun loginUser(@Body data: UserInfo): LoginResponse

    @POST(Constants.API_PATH + Constants.REGISTER_PATH)
    suspend fun registerUser(@Body data: UserInfo) : RegisterResponse

}