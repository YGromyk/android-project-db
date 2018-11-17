package com.gromyk.roomcodelabs.model;

import android.os.AsyncTask;

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */
public class InsertAsyncTask extends AsyncTask<DBWord, Void, Void> {
    private WordDAO wordDAO;
    InsertAsyncTask(WordDAO wordDAO) {
        this.wordDAO = wordDAO;
    }

    @Override
    protected Void doInBackground(DBWord... dbWords) {
        wordDAO.insert(dbWords);
        return null;
    }
}
