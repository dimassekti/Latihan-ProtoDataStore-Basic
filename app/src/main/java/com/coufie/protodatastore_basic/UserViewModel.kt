package com.coufie.protodatastore_basic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(application)

    val data = repository.readProto.asLiveData()

    fun update(name : String) = viewModelScope.launch {
        repository.updateData(name)
    }

    fun delete() = viewModelScope.launch {
        repository.hapus()
    }
}