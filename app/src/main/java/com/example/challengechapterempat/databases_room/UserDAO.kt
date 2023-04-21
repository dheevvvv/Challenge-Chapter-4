package com.example.challengechapterempat.databases_room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDAO {
    @Insert
    fun insertUser(userData: UserData)
}