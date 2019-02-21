package com.strangelove.vkmessenger.viewmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strangelove.vkmessenger.R
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import dagger.android.AndroidInjection
import javax.inject.Inject
import com.vk.api.sdk.auth.VKAccessToken
import android.content.Intent
import com.vk.api.sdk.auth.VKAuthCallback


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //VK.login(this, listOf(VKScope.MESSAGES, VKScope.FRIENDS, VKScope.NOTIFICATIONS))
        viewModel.testExe()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!VK.onActivityResult(requestCode, resultCode, data!!, object : VKAuthCallback {
                override fun onLogin(token: VKAccessToken) {
                    viewModel.saveToken(token.accessToken)
                }

                override fun onLoginFailed(errorCode: Int) {
                    val i = 0
                }
            })) {

            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
