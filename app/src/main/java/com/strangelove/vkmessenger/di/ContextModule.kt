package com.strangelove.vkmessenger.di

import android.content.Context
import android.content.SharedPreferences
import com.strangelove.vkmessenger.Const
import com.strangelove.vkmessenger.model.data.StorageUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(val context: Context) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSharedPreferencese(context: Context): SharedPreferences {
        return context.getSharedPreferences(Const.PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideStorageUtil(sharedPreferences: SharedPreferences): StorageUtil {
        return StorageUtil(sharedPreferences.edit())
    }
}