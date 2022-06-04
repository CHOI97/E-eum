package com.cookandroid.e_eum.DBMS

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cookandroid.e_eum.DBMS.KSL
import com.cookandroid.e_eum.DBMS.KSLDao

@Database(entities = [KSL::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun kslDao() : KSLDao
    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context, AppDatabase::class.java, "KSL.db")
                        .createFromAsset("databases/new_ksl.db")
                        .build()
                    Log.d("success","true")
                }
            }
            return instance
        }
    }
}
//val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"sign.db")
//    .createFromAsset("sign.db")
//    .build()
