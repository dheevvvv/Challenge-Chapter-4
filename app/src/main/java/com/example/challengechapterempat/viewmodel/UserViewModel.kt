package com.example.challengechapterempat.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.challengechapterempat.databases_room.NoteDatabase
import com.example.challengechapterempat.databases_room.UserData
import com.example.challengechapterempat.datastore_preferences.UserManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    val userManager = UserManager.getInstance(application)
    fun getUsername() {
        viewModelScope.launch {
            val username = userManager.getUsername()
            _username.value = username
        }
    }

    fun insertUser(userData: UserData){
        GlobalScope.async {
            val userDAO = NoteDatabase.getInstance(getApplication())?.userDao()!!
            userDAO.insertUser(userData)
        }
    }
    fun checkUser(email : String, password : String) : LiveData<UserData> = NoteDatabase.getInstance((getApplication()))!!.userDao().checkUser(email, password)

}