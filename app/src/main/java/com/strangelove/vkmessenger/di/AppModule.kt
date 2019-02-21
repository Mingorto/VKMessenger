package com.strangelove.vkmessenger.di

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.strangelove.vkmessenger.Const
import com.strangelove.vkmessenger.model.network.NetworkInteractor
import com.strangelove.vkmessenger.model.network.NetworkInteractorImplementation
import com.strangelove.vkmessenger.model.network.NetworkService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideJson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .baseUrl(Const.URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(NetworkService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkInteractor(networkService: NetworkService): NetworkInteractor {
        return NetworkInteractorImplementation(networkService)
    }
}