package com.strangelove.vkmessenger.viewmodel

import com.strangelove.vkmessenger.Const
import com.strangelove.vkmessenger.model.network.NetworkInteractor
import com.strangelove.vkmessenger.model.dao.Repo
import com.strangelove.vkmessenger.model.data.StorageUtil
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val networkInteractor: NetworkInteractor, private val storageUtil: StorageUtil): BaseViewModel() {
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

    fun saveToken(token: String) {
        storageUtil.saveString(Const.AUTH_TOKEN, token)
    }
}