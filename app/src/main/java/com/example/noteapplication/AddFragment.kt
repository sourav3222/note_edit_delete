package com.example.noteapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.noteapplication.databinding.FragmentAddBinding


class AddFragment : Fragment() {



    lateinit var binding: FragmentAddBinding
    var showTime:String? = null
    var showType: String? = null
    lateinit var note: Note

    var noteId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)

        noteId = requireArguments().getInt("note")

        if (noteId != 0) {

            note = NoteDatabase.getDB(requireContext()).getNoteDao()
                .loadAllByIds(listOf<Int>(noteId))[0]

            binding.apply {

                titleET.setText(note.titel)
                timeBtn.setText(note.time)
                dateBtn.setText(note.date)

            }

        }



        binding.dateBtn.setOnClickListener{

            pickdate()

        }



        binding.timeBtn.setOnClickListener{

            picktime()

        }


        binding.submitBtn.setOnClickListener {

            val titelstr = binding.titleET.text.toString()
            val datestr = showType ?: "00/00/0000"
            val timestr = showTime ?: "00:00"
            val note = Note(titel = titelstr, time = timestr, date = datestr)
            if (noteId == 0){
                NoteDatabase.getDB(requireContext()).getNoteDao().insertData(note)
            }else{
                note.id = noteId
                NoteDatabase.getDB(requireContext()).getNoteDao().updateData(note)
            }



            findNavController().navigate(R.id.action_addFragment_to_homeFragment)
        }

        return binding.root
    }

    private fun picktime() {
        val calendar = java.util.Calendar.getInstance()

        val minute = calendar.get(java.util.Calendar.MINUTE)
        val hour = calendar.get(java.util.Calendar.HOUR_OF_DAY)

        val timePicker = TimePickerDialog(
            requireActivity(), TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->

                showTime = "$hourOfDay : $minute"
                binding.timeBtn.text = showTime


            }, hour, minute, false

        )
        timePicker.show()


    }

    private fun pickdate() {
        val calendar = Calendar.getInstance()

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val showdata = DatePickerDialog(
            requireActivity(),DatePickerDialog.OnDateSetListener{ view, dayOfMonth, month , year ->


                showType = "$day/${month + 1}/$year"
                binding.dateBtn.text = showType
            },year, month, day
        )
        showdata.show()
    }
    }


