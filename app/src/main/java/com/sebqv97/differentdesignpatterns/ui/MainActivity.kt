package com.sebqv97.differentdesignpatterns.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebqv97.differentdesignpatterns.R
import com.sebqv97.differentdesignpatterns.adapters.UserRvAdapter
import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.data.models.Users
import com.sebqv97.differentdesignpatterns.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
        private lateinit var binding : ActivityMainBinding

        @Inject lateinit var userApi:UserApiDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)

        getUsersData(applicationContext)

        setContentView(binding.root)


    }





    // Get data from DataSource(Users Api in our case)
 private fun getUsersData(context: Context){
     CoroutineScope(Dispatchers.Main).launch {

         try {
             val response = userApi.getUsers()
             Log.d("Response",response.body().toString())
             if(response.isSuccessful){
                 val users = response.body() ?: {throw Throwable("Body of the Api is null")}

                 //NOT NULL -> CALL the displayUserData function
                 displayUserData(users as Users,context)



             }
         }catch (e:Exception){
             Log.d("Response Error", e.message.toString())
         }
     }
}


    //Display Data to the Widgets

    private fun displayUserData(users:Users,context: Context){

        //get the recyclerView
        binding.rvUsers.apply {

            //Set layout manager
            layoutManager = LinearLayoutManager(context)
            adapter = UserRvAdapter(users)
        }


    }
}