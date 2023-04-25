package com.example.challengechapterempat.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.challengechapterempat.R
import com.example.challengechapterempat.adapter.NoteAdapter
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

    companion object {
        const val ARG_NOTE_DATA = "note_data"

        fun newInstance(noteData: NoteData): EditNoteFragment {
            val args = Bundle().apply {
                putSerializable(ARG_NOTE_DATA, noteData)
            }
            val fragment = EditNoteFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_edit_note)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)
        val arguments = arguments?.getSerializable(ARG_NOTE_DATA) as NoteData
        binding.onClick = this
        binding.etJudulEdit.setText(arguments.title)
        binding.etDateEdit.setText(arguments.date)
        binding.etContentEdit.setText(arguments.content)

        binding.btnSaveEdit.setOnClickListener {
            saveEdit()
        }
        binding.btnCancelEdit.setOnClickListener {
            cancelEdit()
        }
    }

    fun saveEdit(){
        val arguments = arguments?.getSerializable(ARG_NOTE_DATA) as NoteData
        val judul = binding.etJudulEdit.text.toString()
        val content = binding.etContentEdit.text.toString()
        val date = binding.etDateEdit.text.toString()
        noteViewModel.editNote(NoteData(id = arguments.id , title = judul, content = content, date = date))
        Toast.makeText(requireContext(), "save edit note berhasil", Toast.LENGTH_SHORT).show()
        dismiss()
        noteViewModel.getDataNotes()
    }

    fun cancelEdit(){
        dismiss()
    }
    
}