package com.strangelove.vkmessenger.viewmodel

import android.util.Log
import com.strangelove.vkmessenger.Const
import com.strangelove.vkmessenger.model.network.NetworkInteractor
import com.strangelove.vkmessenger.model.dao.Repo
import com.strangelove.vkmessenger.model.data.StorageUtil
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.HttpException

class MainViewModel(private val networkInteractor: NetworkInteractor, private val storageUtil: StorageUtil): BaseViewModel() {
    fun testExe() {
        networkInteractor.listRepos("mingorto")
        GlobalScope.launch(Dispatchers.Main) {
            val request = networkInteractor.listRepos("mingorto")

            try {
                val response = request.await();
            } catch (e: HttpException) {
                Log.d("12345", e.message())
            } catch (e: Throwable) {
                Log.d("12345", "Ooops: Something else went wrong")
            }
        }
    }

    fun saveToken(token: String) {
        storageUtil.saveString(Const.AUTH_TOKEN, token)
    }
}