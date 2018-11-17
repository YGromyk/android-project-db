package com.gromyk.roomcodelabs.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */

@Dao
interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg word: DBWord)

    @Update
    fun update(word: DBWord)

    @Delete
    fun delete(word: DBWord)

    @Query("select word from DBWORDS order by word asc")
    fun getAllWords(): LiveData<List<DBWord>>
}