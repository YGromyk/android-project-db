package com.gromyk.roomcodelabs;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.gromyk.roomcodelabs.model.DBWord;
import com.gromyk.roomcodelabs.model.Repository;

import java.util.List;

/**
 * Created by Yuriy Gromyk on 11/16/18.
 */
public class WordViewModel extends AndroidViewModel {
    private Repository wordRepository;

    private LiveData<List<DBWord>> allWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new Repository(application);
        allWords = wordRepository.getAllWords();
    }

    public LiveData<List<DBWord>> getAllWords() {
        return allWords;
    }

    public void insert(DBWord word) {
        wordRepository.insert(word);
    }


}
