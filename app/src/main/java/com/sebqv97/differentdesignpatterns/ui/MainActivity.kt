package com.sebqv97.differentdesignpatterns.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebqv97.differentdesignpatterns.adapters.UserRvAdapter
import com.sebqv97.differentdesignpatterns.data.models.Users
import com.sebqv97.differentdesignpatterns.databinding.ActivityMainBinding
import com.sebqv97.differentdesignpatterns.domain.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var usersViewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Instantiating variables
        binding = ActivityMainBinding.inflate(layoutInflater)
        usersViewModel = ViewModelProvider(this@MainActivity)[UsersViewModel::class.java]

        getUsers() //FUNCTION THAT FETCHES DATA FROM 'API' and passes it for DISPLAY

        setContentView(binding.root)


    }


    // Get data from DataSource(Users Api in our case)
    private fun getUsers() {

        //ASK the ViewModel to procure our data from data Layer
        usersViewModel.getUsersFromApi()

        /*By DEFAULT the data stored in LiveData variable is dummy.
            As SOON as data gets procured, the observe function will get triggered */
        usersViewModel._usersLiveData.observe(this@MainActivity)
        { users -> displayUsersToRv(users) } //Call another function to display data (SRP)

    }

    private fun displayUsersToRv(users: Users) {

        //Configure the Recycler View(Adapter and LayoutManager)
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = UserRvAdapter(users)
        }

    }

}