package com.example.noteapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface NoteDao {


    @Insert
    fun insertData(note: Note)

    @Update
    fun updateData(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("Select  * From Note")
    fun getAllData():List<Note>

    @Query("SELECT * FROM Note WHERE id IN (:id)")
    fun loadAllByIds(id: List<Int>): List<Note>

}