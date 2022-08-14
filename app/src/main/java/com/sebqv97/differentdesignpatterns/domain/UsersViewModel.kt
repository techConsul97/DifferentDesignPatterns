package com.sebqv97.differentdesignpatterns.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.data.models.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    val userApiDetails: UserApiDetails
) : ViewModel() {

     var _usersLiveData : MutableLiveData<Users> = MutableLiveData(Users())

    fun getUsersFromApi(){

        CoroutineScope(Dispatchers.IO).launch {
            try {

                val response = userApiDetails.getUsers()
                if(response.isSuccessful)
                {
                    if(response.body()!!.isNotEmpty())
                        _usersLiveData.postValue(response.body())
                    else
                        Log.e("ERROR","Response body is null, but call worked")
                }
                else{
                    Log.e("ERROR","Response was unsuccessful")
                }


            }catch (e:Exception){
                throw Exception(e.message)
            }
        }

    }

}