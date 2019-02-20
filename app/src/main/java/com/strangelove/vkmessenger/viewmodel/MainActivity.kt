package com.strangelove.vkmessenger.viewmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strangelove.vkmessenger.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.testExe()
    }
}
