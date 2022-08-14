package com.sebqv97.differentdesignpatterns.domain.repository

import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.data.models.Users
import retrofit2.Response
import javax.inject.Inject

class UsersRepository @Inject constructor(
    val userApiDetails: UserApiDetails
) : IUsersRepository{
    override suspend fun getUsersFromApiDataSource() = userApiDetails.getUsers()


////================================================================================///
    override suspend fun editUsersFromApiDataSource() {}

    override suspend fun deleteUserFromApiDataSource() {}

    override suspend fun addUserToApiDataSource() {}


    //============================================================================//

    override suspend fun getUsersFromLocalDb() {}

    override suspend fun editUserFromLocalDb() {}

    override suspend fun deleteUserFromLocalDb() {}

    override suspend fun addUserFromLocalDb() {}


}