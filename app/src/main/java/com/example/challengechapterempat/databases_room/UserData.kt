package com.example.challengechapterempat.databases_room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class UserData (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var username : String,
    var email : String,
    var password: String
): Serializable