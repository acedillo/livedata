package com.example.cedilla.myapp.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(var firstName : String = "",
                var lastName : String = ""){

    @PrimaryKey(autoGenerate = true) var id : Int? = null
}

