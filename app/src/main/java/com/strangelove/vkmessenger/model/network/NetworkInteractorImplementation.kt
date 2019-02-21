package com.strangelove.vkmessenger.model.network

import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response

class NetworkInteractorImplementation(private val networkService: NetworkService):
    NetworkInteractor {
    override fun listRepos(user: String): Deferred<Response<List<Repo>>> {
        return networkService.listRepos(user)
    }
}