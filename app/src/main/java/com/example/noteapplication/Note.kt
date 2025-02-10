package com.example.noteapplication

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Note(

@PrimaryKey(autoGenerate = true)
    var id : Int= 0,
    val titel: String,
    val time: String,
    val date: String,
): Parcelable
