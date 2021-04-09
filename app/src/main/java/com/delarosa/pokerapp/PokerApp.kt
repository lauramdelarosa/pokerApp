package com.delarosa.pokerapp

import android.app.Application
import com.delarosa.pokerapp.di.initDI

class PokerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}