package com.mleiva.loginretrofit.retrofit

import com.mleiva.loginretrofit.Constants
import retrofit2.http.GET

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit.retrofit
 * Creted by: Marcelo Leiva on 15-02-2024 at 21:16
 ***/
interface UserService {
    @GET(Constants.API_PATH + Constants.USERS_PATH + Constants.TWO_PATH)
    suspend fun getSigleUser() : SingleUserResponse
}