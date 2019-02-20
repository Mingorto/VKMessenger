package com.strangelove.vkmessenger.viewmodel

import com.strangelove.vkmessenger.model.NetworkInteractor
import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val networkInteractor: NetworkInteractor): BaseViewModel() {
    fun testExe() {
        networkInteractor.listRepos("mingorto")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<Repo>> {
                override fun onSuccess(t: List<Repo>) {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                }
            })
    }
}