package com.strangelove.vkmessenger

import android.app.Activity
import android.app.Application
import android.app.Service
import com.strangelove.vkmessenger.di.ContextModule
import com.strangelove.vkmessenger.di.DaggerAppComponent
import com.vk.api.sdk.VK
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasServiceInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return dispatchingServiceInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
            .inject(this)

        VK.initialize(this)
    }
}