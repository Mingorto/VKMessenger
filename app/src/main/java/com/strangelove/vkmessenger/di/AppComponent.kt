package com.strangelove.vkmessenger.di

import com.strangelove.vkmessenger.App
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class, ViewModelModule::class, ContextModule::class])
interface AppComponent {
    fun inject(application: App)

    @Component.Builder
    interface Builder {
        fun contextModule(contextModule: ContextModule): Builder
        fun build(): AppComponent
    }
}