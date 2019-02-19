package com.strangelove.vkmessenger.model

import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    @GET("users/{user}/repos")
    public fun listRepos(@Path("user") user: String): Single<List<Repo>>
}