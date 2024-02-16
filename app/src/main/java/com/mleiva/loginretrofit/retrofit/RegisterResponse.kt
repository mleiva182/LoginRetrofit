package com.mleiva.loginretrofit.retrofit

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit.retrofit
 * Creted by: Marcelo Leiva on 15-02-2024 at 21:19
 ***/
data class RegisterResponse(var token: String, var id: String) : SuccessResponse(token)
