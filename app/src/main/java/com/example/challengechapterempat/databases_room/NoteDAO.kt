package com.example.challengechapterempat.databases_room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface NoteDAO {
    @Insert
    fun insertNote(note: NoteData)

    @Query("SELECT * FROM NoteData ORDER BY id DESC ")
    fun getDataNote() : List<NoteData>

    @Delete
    fun deleteNote(note: NoteData)

    @Update
    fun updateNote(note: NoteData)
}