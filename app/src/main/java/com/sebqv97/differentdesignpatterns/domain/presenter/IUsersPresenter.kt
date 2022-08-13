package com.sebqv97.differentdesignpatterns.domain.presenter

import com.sebqv97.differentdesignpatterns.data.models.Users
import retrofit2.Response

interface IUsersPresenter {
    suspend fun getUsersFromApi() :Response<Users>
    fun returnUsersToDisplay () : Users
}