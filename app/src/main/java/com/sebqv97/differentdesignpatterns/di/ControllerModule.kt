package com.sebqv97.differentdesignpatterns.di

import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit


@Module
@InstallIn(ActivityComponent::class)
object ControllerModule {


    @Provides
    fun getUserApiReference(retrofit: Retrofit): UserApiDetails = retrofit.create(UserApiDetails::class.java)
}