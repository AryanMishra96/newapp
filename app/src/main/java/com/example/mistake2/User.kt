package com.example.mistake2
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity (tableName = "user_table")
 data class User (
    @PrimaryKey val email : String,
            val password : String ?=null
)