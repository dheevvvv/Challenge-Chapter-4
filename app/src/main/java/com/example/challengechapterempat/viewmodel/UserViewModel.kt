package com.example.challengechapterempat.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.challengechapterempat.databases_room.NoteDatabase
import com.example.challengechapterempat.databases_room.UserData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class UserViewModel(application: Application): AndroidViewModel(application) {
    private var _username : MutableLiveData<String> = MutableLiveData()
    val username : LiveData<String> get() = _username

    fun insertUser(user : UserData){
        GlobalScope.async {
            val userDAO = NoteDatabase.getInstance(getApplication())?.userDao()!!
            userDAO.insertUser(user)
        }
    }

    fun setUsername(user: String){
        _username.value = user
    }
}