package com.example.challengechapterempat.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databases_room.NoteData
import com.example.challengechapterempat.databinding.FragmentAddNoteBinding
import com.example.challengechapterempat.viewmodel.NoteViewModel


class AddNoteFragment : DialogFragment() {
    private lateinit var binding:FragmentAddNoteBinding
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        binding.btnCancelAdd.setOnClickListener {
            cancelAdd()
        }
        binding.btnSaveAdd.setOnClickListener {
            saveAdd()
        }
    }


    fun saveAdd(){
        val judul = binding.etJudulAdd.text.toString()
        val content = binding.etContentAdd.text.toString()
        val date = binding.etDateAdd.text.toString()
        noteViewModel.addNote(NoteData(0,judul,content,date))
        Toast.makeText(requireContext(), "save note berhasil", Toast.LENGTH_SHORT).show()
        dismiss()
    }

    fun cancelAdd(){
        dismiss()
    }


}