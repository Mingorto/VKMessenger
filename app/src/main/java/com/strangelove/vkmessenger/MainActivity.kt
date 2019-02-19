package com.strangelove.vkmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strangelove.vkmessenger.model.NetworkInteractorImplementation
import com.strangelove.vkmessenger.model.NetworkProvider
import com.strangelove.vkmessenger.model.dao.Repo
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkBuilder = NetworkProvider()
        val service = networkBuilder.buildService()

        val interactor = NetworkInteractorImplementation(service)
        interactor.listRepos("mingorto")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<Repo>> {
                override fun onSuccess(t: List<Repo>) {
                    val i = 0;

                }

                override fun onSubscribe(d: Disposable) {
                    val i = 0;
                }

                override fun onError(e: Throwable) {
                    val i = 0;
                }
            })
    }
}
