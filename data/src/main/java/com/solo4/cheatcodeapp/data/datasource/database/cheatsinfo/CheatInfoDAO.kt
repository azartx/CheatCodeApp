package com.solo4.cheatcodeapp.data.datasource.database.cheatsinfo

import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.solo4.cheatcodeapp.data.model.CheatInfoDto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface CheatInfoDAO {
    @Query("SELECT * FROM cheat_info_table")
    fun getAllCheatsInfo(): Observable<List<CheatInfoDto>>
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCheatInfo(cheatInfo: CheatInfoDto): Completable
}