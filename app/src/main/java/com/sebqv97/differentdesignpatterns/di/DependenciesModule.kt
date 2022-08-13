package com.sebqv97.differentdesignpatterns.di

import com.google.gson.Gson
import com.sebqv97.differentdesignpatterns.data.api.API_REFERENCE
import com.sebqv97.differentdesignpatterns.data.api.UserApiDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(ActivityComponent::class)
object DependenciesModule {

    @Provides
    fun getGsonReference():Gson = Gson()

    @Provides
    fun getOkHttpInterceptorReference():HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    fun getOkHttpReference(httpLoggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .callTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
   fun getRetrofitInstance(gson: Gson,okHttpClient: OkHttpClient ): Retrofit = Retrofit.Builder()
        .baseUrl(API_REFERENCE.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}