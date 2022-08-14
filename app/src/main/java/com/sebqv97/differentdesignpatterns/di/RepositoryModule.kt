package com.sebqv97.differentdesignpatterns.di

import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import com.sebqv97.differentdesignpatterns.domain.repository.IUsersRepository
import com.sebqv97.differentdesignpatterns.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    fun getUserApiReference(retrofit: Retrofit): UserApiDetails = retrofit.create(UserApiDetails::class.java)

    @Provides
    fun getUsersRepositoryReference(userApiDetails: UserApiDetails): IUsersRepository = UsersRepository(userApiDetails)
}