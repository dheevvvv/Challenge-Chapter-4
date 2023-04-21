package com.example.challengechapterempat.databases_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NoteData::class, UserData::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao(): NoteDAO
    abstract fun userDao(): UserDAO
    companion object{

        private var INSTANCE : NoteDatabase? = null

        fun getInstance(context : Context):NoteDatabase? {
            if (INSTANCE == null){
                synchronized(NoteDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NoteDatabase::class.java,"Note.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}