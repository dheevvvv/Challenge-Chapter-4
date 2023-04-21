package com.example.challengechapterempat.databases_room

import androidx.room.*


@Dao
interface NoteDAO {
    @Insert
    suspend fun insertNote(note: NoteData)

    @Query("SELECT * FROM NoteData ")
    suspend fun getDataNote() : List<NoteData>

    @Query("SELECT * FROM NoteData ORDER BY title DESC")
    suspend fun getAllNotesDesc(): List<NoteData>

    @Query("SELECT * FROM NoteData ORDER BY title ASC")
    suspend fun getAllNotesAsc(): List<NoteData>

    @Delete
    suspend fun deleteNote(note: NoteData)

    @Update
    suspend fun updateNote(note: NoteData)
}