package com.strangelove.vkmessenger.model.network

import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Path

interface NetworkInteractor {
    fun listRepos(user: String): Deferred<Response<List<Repo>>>
}