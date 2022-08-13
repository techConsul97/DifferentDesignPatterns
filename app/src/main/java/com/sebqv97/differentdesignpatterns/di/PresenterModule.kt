package com.sebqv97.differentdesignpatterns.di

import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.domain.presenter.IUsersPresenter
import com.sebqv97.differentdesignpatterns.domain.presenter.UsersPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(ActivityComponent::class)
object PresenterModule {


    //USERS_PRESENTER
    @Provides
    fun getUserApiReference(retrofit: Retrofit): UserApiDetails = retrofit.create(UserApiDetails::class.java)


    //MAIN ACTIVITY
    @Provides
    fun getUsersPresenterReference(usersPresenter: UsersPresenter):IUsersPresenter = usersPresenter
}