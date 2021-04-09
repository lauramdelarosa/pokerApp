package com.delarosa.pokerapp.di

import android.app.Application
import com.delarosa.pokerapp.domain.GetHand
import com.delarosa.pokerapp.domain.Poker
import com.delarosa.pokerapp.view.MainActivity
import com.delarosa.pokerapp.view.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(presentationModule))
    }
}

private val presentationModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(poker = get(), getHand = get()) }
    }
    factory { Poker() }
    factory { GetHand() }
}
