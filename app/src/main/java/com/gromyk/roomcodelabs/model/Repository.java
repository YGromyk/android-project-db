package com.gromyk.roomcodelabs.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */
public class Repository {
    private WordDAO wordDAO;
    private LiveData<List<DBWord>> allWords;

    public Repository(Application application) {
        WordDataBase db = WordDataBase.getDataBase(application);
        wordDAO = db.getWordDAO();
        allWords = wordDAO.getAllWords();
    }

    public LiveData<List<DBWord>> getAllWords() {
        return allWords;
    }

    public void insert(DBWord dbWord) {
        new InsertAsyncTask(wordDAO).execute(dbWord);
    }
}
