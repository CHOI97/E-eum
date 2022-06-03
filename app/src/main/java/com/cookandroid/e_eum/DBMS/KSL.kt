package com.cookandroid.e_eum.DBMS

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KSL(
//Prime key
    @PrimaryKey var origin_no: String,
//ColumnInfo
    @ColumnInfo var category: String,
    @ColumnInfo var mean: String)

