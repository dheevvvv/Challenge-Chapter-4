package com.example.challengechapterempat.databases_room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    fun insertUser(userData: UserData)

    @Query("SELECT * FROM Userdata WHERE email = :email AND password = :password")
    fun checkUser(email : String, password : String): LiveData<UserData>
}