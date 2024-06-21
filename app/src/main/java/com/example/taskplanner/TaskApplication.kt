package com.example.taskplanner

import android.app.Application
import com.example.taskplanner.data.AppContainer

class TaskApplication: Application() {
    lateinit var  container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}