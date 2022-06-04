package com.cookandroid.e_eum.DBMS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KSLDao {
    @Query("SELECT * FROM KSL")
    fun getAll(): List<KSL>

    @Query("SELECT * FROM KSL WHERE category = :search_category")
    fun getCategory(search_category: String): List<KSL>

    @Query("SELECT * FROM KSL WHERE category = :search_category AND origin_no = :search_origin_no")
    fun getKSLData(search_category:String, search_origin_no:String): KSL
    @Query("SELECT * FROM KSL where ROWID=:random_index")
    fun getRandomKSL(random_index: Int): KSL
    @Insert
    fun insertAll(vararg users: KSL)

    @Delete
    fun delete(user: KSL)
}