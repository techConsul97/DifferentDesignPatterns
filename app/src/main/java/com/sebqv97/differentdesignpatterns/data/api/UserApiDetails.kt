package com.sebqv97.differentdesignpatterns.data.api

import com.sebqv97.differentdesignpatterns.data.models.Users
import retrofit2.Response
import retrofit2.http.GET



interface UserApiDetails {

    @GET(API_REFERENCE.USER_ENDPOINT)

     suspend fun getUsers(): Response<Users>
}