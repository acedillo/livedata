package com.example.cedilla.myapp.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.content.Context
import com.example.cedilla.myapp.model.User

class DatabaseDataSource private constructor(context: Context) {

    companion object {

        @Volatile private var INSTANCE : DatabaseDataSource? = null
        fun getInstance(context: Context) : DatabaseDataSource{
           if (INSTANCE == null){
               INSTANCE = DatabaseDataSource(context)
           }
            return INSTANCE!!
        }

    }

    val database: AppDataBase = Room.databaseBuilder(context,
            AppDataBase::class.java, "db")
            .build()

    fun insert(vararg user: User){
        Thread{database.userDao().insertAll(*user)}.start()
    }

    fun getAll() : LiveData<List<User>>{
        return database.userDao().getAll()
    }

    fun getCount() : LiveData<Int>{
        return database.userDao().getCount()
    }
}