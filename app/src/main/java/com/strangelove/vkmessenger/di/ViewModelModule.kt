package com.strangelove.vkmessenger.di

import com.strangelove.vkmessenger.model.NetworkInteractor
import com.strangelove.vkmessenger.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    fun provideMainViewModel(networkInteractor: NetworkInteractor): MainViewModel {
        return MainViewModel(networkInteractor)
    }
}