package com.example.challengechapterempat.databases_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_note")
data class NoteData(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "title")
    var title : String,
    @ColumnInfo(name = "content")
    var content : String,
    @ColumnInfo(name = "date")
    var date: String
): Serializable