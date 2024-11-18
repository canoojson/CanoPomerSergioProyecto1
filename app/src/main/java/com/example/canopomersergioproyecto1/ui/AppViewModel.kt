package com.example.canopomersergioproyecto1.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel: ViewModel {
    private val _appUIState = MutableStateFlow(AppUIState())
}