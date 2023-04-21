package com.example.challengechapterempat.databases_room

import androidx.room.PrimaryKey
import java.io.Serializable

data class NoteData(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var content : String,
    var date: String
): Serializable