package com.anil.gctestmodule.di

import com.anil.gctestmodule.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MainViewModel(get()) }
}
