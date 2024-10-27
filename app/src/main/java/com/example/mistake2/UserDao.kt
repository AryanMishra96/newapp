package com.example.mistake2
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface UserDao {
    @Insert
suspend fun insert (user: User): Long
@Query("SELECT * FROM user_table WHERE email = :email" )
suspend fun getUserByEmail(email: String) : User?

}