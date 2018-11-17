package com.gromyk.roomcodelabs.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */
@Database(entities = {DBWord.class}, version = 1)
public abstract class WordDataBase extends RoomDatabase {
    private static volatile WordDataBase INSTANCE = null;

    public abstract WordDAO getWordDAO();

    public static WordDataBase getDataBase(Context context) {
        if (INSTANCE == null) {
            synchronized (WordDataBase.class) {
                INSTANCE = Room
                        .databaseBuilder(
                                context.getApplicationContext(),
                                WordDataBase.class,
                                "wordDB"
                        )
                        .build();
            }
        }
        return INSTANCE;
    }

}
