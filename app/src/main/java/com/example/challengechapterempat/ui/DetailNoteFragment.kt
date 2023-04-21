package com.example.challengechapterempat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databinding.FragmentDetailNoteBinding


class DetailNoteFragment : Fragment() {
    private lateinit var binding:FragmentDetailNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}