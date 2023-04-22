package com.example.challengechapterempat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechapterempat.R
import com.example.challengechapterempat.databases_room.NoteData
import com.example.challengechapterempat.databases_room.NoteDatabase
import com.example.challengechapterempat.databinding.ItemNoteBinding
import com.example.challengechapterempat.ui.HomeFragment
import com.example.challengechapterempat.ui.HomeFragmentDirections
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.ArrayList

class NoteAdapter(var listNote: List<NoteData>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    var DBNote : NoteDatabase? = null

    class ViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.binding.tvJudul.text = listNote[position].title.toString()
        holder.binding.tvDate.text = listNote[position].date
        holder.binding.tvContent.text = listNote[position].content
        holder.binding.ivDelete.setOnClickListener {
            DBNote = NoteDatabase.getInstance(it.context)

            GlobalScope.async {
                DBNote?.noteDao()?.deleteNote(listNote[position])
            }
        }

        holder.binding.ivEdit.setOnClickListener { view ->
            val bundle = bundleOf("dataedit" to listNote[position])
            view.findNavController().navigate(R.id.action_homeFragment_to_editNoteFragment, bundle)
        }

        holder.binding.itemClick.setOnClickListener { view ->
            val bundle = bundleOf("detail" to listNote[position])
            view.findNavController().navigate(R.id.action_homeFragment_to_detailNoteFragment, bundle)
        }



    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    fun setNoteData(listNote: ArrayList<NoteData>)
    {
        this.listNote=listNote
    }

}