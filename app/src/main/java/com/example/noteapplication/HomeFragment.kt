package com.example.noteapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.noteapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), NoteAdapter.NoteEdit {

    lateinit var binding: FragmentHomeBinding
    lateinit var note: Note



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentHomeBinding.inflate(inflater,container,false)



        var notes: List<Note> = NoteDatabase.getDB(requireContext()).getNoteDao().getAllData()

        notes.let {
            var adapter = NoteAdapter(this)
            adapter.submitList(notes)

            binding.recyclerview.adapter = adapter

        }



        binding.addBtn.setOnClickListener {


            findNavController().navigate(R.id.action_homeFragment_to_addFragment)

        }


        return binding.root
    }

    override fun onNoteEdit(note: Note) {
        var bundle = Bundle()
        bundle.putInt("note", note.id)

        findNavController().navigate(R.id.action_homeFragment_to_addFragment, bundle)


    }


}