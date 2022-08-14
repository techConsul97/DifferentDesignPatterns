package com.sebqv97.differentdesignpatterns.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebqv97.differentdesignpatterns.R
import com.sebqv97.differentdesignpatterns.adapters.UserRvAdapter
import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.data.models.Users
import com.sebqv97.differentdesignpatterns.databinding.ActivityMainBinding
import com.sebqv97.differentdesignpatterns.domain.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
        private lateinit var binding : ActivityMainBinding
        private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Instantiating variables
            binding = ActivityMainBinding.inflate(layoutInflater)
            usersViewModel = ViewModelProvider(this@MainActivity)[UsersViewModel::class.java]

        getUsersData() //FUNCTION THAT FETCHES DATA FROM 'API' and passes it for DISPLAY

        setContentView(binding.root)


    }





    // Get data from DataSource(Users Api in our case)
 private fun getUsersData(){

      usersViewModel.getUsersFromApi()
     usersViewModel._usersLiveData.observe(this@MainActivity){users->
         displayUsersToRv(users)


     }
    }

    private fun displayUsersToRv(users: Users){

        //Configure the Recycler View(Adapter and LayoutManager)
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = UserRvAdapter(users)
        }

    }

}