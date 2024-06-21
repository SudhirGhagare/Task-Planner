package com.example.taskplanner.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewmodel.initializer
import com.example.taskplanner.TaskApplication
import com.example.taskplanner.ui.screen.HomeScreenViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            HomeScreenViewModel(taskApplication().container.tasksRepository)
        }
    }
}
fun CreationExtras.taskApplication(): TaskApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TaskApplication)