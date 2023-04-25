package com.example.challengechapterempat.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.challengechapterempat.databases_room.NoteData
import com.example.challengechapterempat.databases_room.NoteDatabase
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {

    private var _listNote : MutableLiveData<List<NoteData>> = MutableLiveData()
    val listNote: LiveData<List<NoteData>> get() = _listNote


    fun getAllNotesDesc() = viewModelScope.launch {
        _listNote.postValue(NoteDatabase.getInstance((getApplication()))!!.noteDao().getAllNotesDesc())
    }

    fun getAllNotesAsc() = viewModelScope.launch {
        _listNote.postValue(NoteDatabase.getInstance((getApplication()))!!.noteDao().getAllNotesAsc())
    }

    fun getDataNotes() = viewModelScope.launch {
        _listNote.postValue(NoteDatabase.getInstance((getApplication()))!!.noteDao().getDataNote())
    }

    fun addNote(noteData: NoteData) = viewModelScope.launch {
        NoteDatabase.getInstance((getApplication()))!!.noteDao().insertNote(noteData)
    }
    fun editNote(noteData: NoteData) = viewModelScope.launch {
        NoteDatabase.getInstance((getApplication()))!!.noteDao().updateNote(noteData)
    }
}

