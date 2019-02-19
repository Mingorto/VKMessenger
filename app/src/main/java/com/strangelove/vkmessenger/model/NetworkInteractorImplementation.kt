package com.strangelove.vkmessenger.model

import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.Single

class NetworkInteractorImplementation(private val networkService: NetworkService): NetworkInteractor {
    override fun listRepos(user: String): Single<List<Repo>> {
        return networkService.listRepos(user)
    }
}