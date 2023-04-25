package com.example.challengechapterempat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databases_room.NoteData
import com.example.challengechapterempat.databinding.FragmentDetailNoteBinding
import com.example.challengechapterempat.viewmodel.NoteViewModel


class DetailNoteFragment : Fragment() {
    private lateinit var binding:FragmentDetailNoteBinding
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val getDetailNote = arguments?.getSerializable("note_detail")
        binding.itemdetail = getDetailNote as NoteData?
        binding.onClick = this
        binding.btnProfile.setOnClickListener {
            profile()
        }
        binding.btnBack.setOnClickListener {
            back()
        }
    }

    fun profile(){
        findNavController().navigate(R.id.action_detailNoteFragment_to_profileFragment)
    }

    fun back(){
        requireActivity().onBackPressed()
    }




}