package com.mleiva.loginretrofit.retrofit

import com.google.gson.annotations.SerializedName
import com.mleiva.loginretrofit.Constants

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit.retrofit
 * Creted by: Marcelo Leiva on 15-02-2024 at 21:15
 ***/
class UserInfo(
 @SerializedName(Constants.EMAIL_PARAM) val email: String,
 @SerializedName(Constants.PASSWORD_PARAM) val pass: String
)