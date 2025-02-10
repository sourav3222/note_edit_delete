package com.example.noteapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao() : NoteDao


    companion object{

        var database : NoteDatabase? = null


        fun getDB(context: Context) : NoteDatabase{

            if (database ==null){


                database = Room.databaseBuilder(context, NoteDatabase::class.java, "Note-DB")
                    .allowMainThreadQueries().build()


                return database as NoteDatabase

            }else{
                return database as NoteDatabase
            }


        }


    }





}



