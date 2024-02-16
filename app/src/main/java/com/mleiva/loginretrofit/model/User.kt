package com.mleiva.loginretrofit.model

/***
 * Project: LoginRetrofit
 * From: com.mleiva.loginretrofit.model
 * Creted by: Marcelo Leiva on 15-02-2024 at 20:48
 ***/
data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
){
    fun getFullName(): String = "$firstName $lastName"

}
