package com.example.challengechapterempat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databases_room.NoteData
import com.example.challengechapterempat.databinding.FragmentEditNoteBinding
import com.example.challengechapterempat.viewmodel.NoteViewModel


class EditNoteFragment : DialogFragment() {
    private lateinit var binding:FragmentEditNoteBinding
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        binding.btnSaveEdit.setOnClickListener {
            saveEdit()
        }
        binding.btnCancelEdit.setOnClickListener {
            cancelEdit()
        }
    }

    fun saveEdit(){
        val judul = binding.etJudulEdit.text.toString()
        val content = binding.etContentEdit.text.toString()
        val date = binding.etDateEdit.text.toString()
        noteViewModel.editNote(NoteData(0,judul,content,date))
        Toast.makeText(requireContext(), "save edit note berhasil", Toast.LENGTH_SHORT).show()
        dismiss()
    }

    fun cancelEdit(){
        dismiss()
    }
    
}