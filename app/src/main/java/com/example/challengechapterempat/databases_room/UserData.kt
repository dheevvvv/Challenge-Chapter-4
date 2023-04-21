package com.example.challengechapterempat.databases_room

import androidx.room.PrimaryKey
import java.io.Serializable

class UserData (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var username : String,
    var email : String,
    var password: String
): Serializable