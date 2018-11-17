package com.gromyk.roomcodelabs.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */

@Entity(tableName = "dbWords")
data class DBWord(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "word")
    var word: String
)