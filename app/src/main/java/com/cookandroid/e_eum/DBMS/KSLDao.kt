package com.cookandroid.e_eum.DBMS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KSLDao {
    @Query("SELECT * FROM KSL")
    fun getAll(): List<KSL>


    @Insert
    fun insertAll(vararg users: KSL)

    @Delete
    fun delete(user: KSL)
}