package com.solo4.cheatcodeapp.data.datasource.database.cheatsinfo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.solo4.cheatcodeapp.data.model.CheatInfoDto

@Database(entities = [CheatInfoDto::class], version = 1)
abstract class CheatsInfoDatabase : RoomDatabase() {
    abstract fun cheatInfoDao(): CheatInfoDAO

    companion object {
        fun create(context: Context): CheatsInfoDatabase {
            return Room.databaseBuilder(context, CheatsInfoDatabase::class.java, "cheat_info_db")
                .build()
        }
    }
}
