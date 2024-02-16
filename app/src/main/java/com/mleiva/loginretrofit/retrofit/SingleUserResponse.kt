package com.mleiva.loginretrofit.retrofit

import com.mleiva.loginretrofit.model.Support
import com.mleiva.loginretrofit.model.User

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit.retrofit
 * Creted by: Marcelo Leiva on 15-02-2024 at 21:18
 ***/
data class SingleUserResponse(var data: User, var support: Support)
