package com.sebqv97.differentdesignpatterns.domain.presenter


import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.data.models.Users
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


import javax.inject.Inject
import kotlin.Exception



class UsersPresenter @Inject constructor(
    var userApiDetails:UserApiDetails
): IUsersPresenter {


    override suspend fun getUsersFromApi(): Response<Users> {

        return userApiDetails.getUsers()
    }


    override fun returnUsersToDisplay() : Users{
        var users:Users? = null
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = getUsersFromApi()
                if (response.isSuccessful) {
                    users = response.body() ?: throw Exception("Response body is NULL")
                }
            } catch (e: Exception) {
                throw Exception(e.message)
            }
        }
        while(users == null){} //REPLACES THE THREAD.SLEEP
        return  users!!

    }

    override suspend fun editUserFromApi() {}

    override fun returnConfirmationOfEditingAnUser() {}

    override suspend fun getUsersFromDb() {}

    override fun returnUsersFromDb() {}
}




