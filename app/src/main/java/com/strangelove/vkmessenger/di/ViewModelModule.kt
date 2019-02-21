package com.strangelove.vkmessenger.di

import com.strangelove.vkmessenger.model.network.NetworkInteractor
import com.strangelove.vkmessenger.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun provideMainViewModel(networkInteractor: NetworkInteractor): MainViewModel {
        return MainViewModel(networkInteractor)
    }
}