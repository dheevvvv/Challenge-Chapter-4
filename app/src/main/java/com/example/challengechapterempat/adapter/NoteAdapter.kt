package com.example.challengechapterempat.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databases_room.NoteData
import com.example.challengechapterempat.databases_room.NoteDatabase
import com.example.challengechapterempat.databinding.ItemNoteBinding
import com.example.challengechapterempat.ui.HomeFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.ArrayList

class NoteAdapter(private var listNote: List<NoteData>, private val itemClickListener:ItemClickListener): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(noteData: NoteData){
            binding.apply {
                item = noteData
                itemonClick = itemClickListener
            }
        }
    }

    interface ItemClickListener {
        fun edit(noteData: NoteData)
        fun detail(noteData: NoteData)
        fun delete(noteData: NoteData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.bind(listNote[position])
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    fun setNoteData(listNote: ArrayList<NoteData>)
    {
        this.listNote=listNote
    }

}