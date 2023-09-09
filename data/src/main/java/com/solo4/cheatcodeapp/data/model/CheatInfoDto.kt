package com.solo4.cheatcodeapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cheat_info_table")
data class CheatInfoDto(
    @PrimaryKey val id: Int,
    @ColumnInfo("is_favourite") val isFavourite: Boolean
)
