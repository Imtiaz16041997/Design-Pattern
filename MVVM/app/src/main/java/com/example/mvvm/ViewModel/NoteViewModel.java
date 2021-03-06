package com.example.mvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvm.Entity.NoteEntity;
import com.example.mvvm.Repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<NoteEntity>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(NoteEntity noteEntity){
        repository.insert(noteEntity);
    }

    public void update(NoteEntity noteEntity){
        repository.update(noteEntity);
    }

    public void delete(NoteEntity noteEntity){
        repository.delete(noteEntity);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<NoteEntity>> getAllNotes(){
        return allNotes;
    }
}
