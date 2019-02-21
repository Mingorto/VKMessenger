package com.strangelove.vkmessenger.model.network

import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.Single
import retrofit2.http.Path

interface NetworkInteractor {
    fun listRepos(user: String): Single<List<Repo>>
}