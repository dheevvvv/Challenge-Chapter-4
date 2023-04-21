package com.example.challengechapterempat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databinding.FragmentAddNoteBinding


class AddNoteFragment : Fragment() {
    private lateinit var binding:FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container,false)
        return binding.root
    }


}