package com.example.challengechapterempat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechapterempat.R
import com.example.challengechapterempat.adapter.NoteAdapter
import com.example.challengechapterempat.databinding.FragmentHomeBinding
import com.example.challengechapterempat.shared_preferences.FilterPreferences
import com.example.challengechapterempat.viewmodel.NoteViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var filterPreferences: FilterPreferences
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(requireActivity()).get(NoteViewModel::class.java)

        if (filterPreferences.getString("KEY_FILTER").isNullOrEmpty()) {
            noteViewModel.getDataNotes()
        } else if (filterPreferences.getString("KEY_FILTER").equals("ASCENDING", true)) {
            noteViewModel.getAllNotesAsc()
        } else if (filterPreferences.getString("KEY_FILTER").equals("DESCENDING", true)) {
            noteViewModel.getAllNotesDesc()
        }

        recyclerView()
    }

    private fun recyclerView() {
        noteViewModel.listNote.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.apply {
                    tvEmpty.isVisible = false
                    rvNote.isVisible = true
                    rvNote.setHasFixedSize(true)
                    rvNote.adapter = NoteAdapter(ArrayList())
                    rvNote.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }
            } else {
                binding.apply {
                    tvEmpty.isVisible = true
                    rvNote.isVisible = false
                }
            }
        }

    }


}