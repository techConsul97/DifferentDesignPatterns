package com.sebqv97.differentdesignpatterns.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebqv97.differentdesignpatterns.adapters.UserRvAdapter
import com.sebqv97.differentdesignpatterns.databinding.ActivityMainBinding
import com.sebqv97.differentdesignpatterns.domain.presenter.IUsersPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
        private lateinit var binding : ActivityMainBinding

        @Inject lateinit var iUsersPresenter: IUsersPresenter //FIELD INJECTION

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)

       displayUserData()          //FUNCTION THAT WILL 'order' DATA

        setContentView(binding.root)


    }



    //Display Data

    private fun displayUserData(){

        val users  = iUsersPresenter.returnUsersToDisplay() //CALLING THE PRESENTER TO FETCH ME SOME DATA
        users.let {                            //MAKING SURE THE RETURNED DATA IS NOT NULL
            binding.rvUsers.apply {            //IF NOT NULL, SET THE DATA TO VIEW(RECYCLER VIEW IN OUR CASE)

                //Set layout manager
                layoutManager = LinearLayoutManager(context)
                adapter = UserRvAdapter(users)
            }
        }

    }
}