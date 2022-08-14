package com.sebqv97.differentdesignpatterns.domain.presenter

import com.sebqv97.differentdesignpatterns.data.models.Users
import retrofit2.Response

interface IUsersPresenter {

    /* Presenter Interface: contains behaviours our presenter needs to know in order to retrieve/post
    *   different things a User requests to be done.*/
    suspend fun getUsersFromApi() :Response<Users>
    fun returnUsersToDisplay () : Users

    suspend fun editUserFromApi()
    fun returnConfirmationOfEditingAnUser()


    suspend fun getUsersFromDb()
    fun returnUsersFromDb()

}