package com.example.cedilla.myapp.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.cedilla.myapp.model.User
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert


@Dao
interface UserDao{

    @Query("SELECT * FROM User")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE firstName LIKE :first AND " + "lastName LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Query("SELECT count(*) FROM User")
    fun getCount() : LiveData<Int>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}