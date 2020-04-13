package com.anil.gctestmodule.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anil.gctestmodule.MainViewModel
import com.anil.gctestmodule.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


