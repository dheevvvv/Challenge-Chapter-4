package com.example.challengechapterempat.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.challengechapterempat.databases_room.NoteDatabase
import com.example.challengechapterempat.databases_room.UserData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class UserViewModel(application: Application): AndroidViewModel(application) {
    private var _username : MutableLiveData<String> = MutableLiveData()
    val userNameFlow: Flow<String>
        get() = _username.asFlow()

    private var _password : MutableLiveData<String> = MutableLiveData()
    val userPasswordFlow: Flow<String>
        get() = _password.asFlow()

    fun insertUser(user : UserData){
        GlobalScope.async {
            val userDAO = NoteDatabase.getInstance(getApplication())?.userDao()!!
            userDAO.insertUser(user)
        }
    }
    fun checkUser(email : String, password : String) : LiveData<UserData> = NoteDatabase.getInstance((getApplication()))!!.userDao().checkUser(email, password)

    fun setUsername(user: String){
        _username.value = user
    }
}