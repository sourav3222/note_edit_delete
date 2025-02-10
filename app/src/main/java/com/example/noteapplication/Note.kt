package com.example.noteapplication

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Note(

@PrimaryKey(autoGenerate = true)
    var id : Int= 0,
    val titel: String,
    val time: String,
    val date: String,
)
