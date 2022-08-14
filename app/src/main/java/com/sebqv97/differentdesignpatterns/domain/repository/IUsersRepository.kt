package com.sebqv97.differentdesignpatterns.domain.repository

import com.sebqv97.differentdesignpatterns.data.models.Users
import retrofit2.Response

interface IUsersRepository {

    /* This is the interface of the repository Module. It serves as a 'bridge' between our Application
    *  and the Data Sources available to us (Api or Database). The main benefits that come with Repository
    *  are: - Better Separation of Concern
    *       - Better way of testing the app
    *       - Modifying Business Logic or Data Logic won't impact this Module
    *       - Better understanding of code */

    suspend fun getUsersFromApiDataSource() : Response<Users>
    suspend fun editUsersFromApiDataSource()
    suspend fun deleteUserFromApiDataSource()
    suspend fun addUserToApiDataSource()


    suspend fun getUsersFromLocalDb()
    suspend fun editUserFromLocalDb()
    suspend fun deleteUserFromLocalDb()
    suspend fun addUserFromLocalDb()

}