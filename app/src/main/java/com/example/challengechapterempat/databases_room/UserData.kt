package com.example.challengechapterempat.databases_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_userdata")
class UserData (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "username")
    var username : String,
    @ColumnInfo(name = "email")
    var email : String,
    @ColumnInfo(name = "password")
    var password: String
): Serializable