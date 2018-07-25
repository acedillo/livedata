package com.example.cedilla.myapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.cedilla.myapp.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao
}