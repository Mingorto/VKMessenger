package com.strangelove.vkmessenger.model.network

import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Deferred<Response<List<Repo>>>
}