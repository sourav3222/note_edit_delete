package com.example.noteapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.databinding.ItemDesignBinding

class NoteAdapter : ListAdapter<Note, NoteViewHolder>(comperator){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {


        return NoteViewHolder(ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {


        getItem(position).let {
            holder.binding.apply {
                notetitleTV.text = it.titel
                dateTV.text = it.date
                timeTV.text = it.time

            }
        }
    }
    companion object {



        val comperator = object : DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem== newItem
            }

        }
    }

}