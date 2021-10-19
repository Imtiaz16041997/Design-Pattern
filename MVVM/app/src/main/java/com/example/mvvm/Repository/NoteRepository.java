package com.example.mvvm.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mvvm.DAO.NoteDao;
import com.example.mvvm.DB.NoteDatabase;
import com.example.mvvm.Entity.NoteEntity;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<NoteEntity>> allNotes;

    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(NoteEntity noteEntity){
        new InsertNoteAsyncTask(noteDao).execute(noteEntity);

    }

    public void update(NoteEntity noteEntity){
        new UpdateNoteAsyncTask(noteDao).execute(noteEntity);
    }

    public void delete(NoteEntity noteEntity){
        new DeleteNoteAsyncTask(noteDao).execute(noteEntity);
    }

    public void deleteAllNotes(NoteEntity noteEntity){
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<NoteEntity>> getAllNotes(){
        return allNotes;
    }

    private  static class InsertNoteAsyncTask extends AsyncTask<NoteEntity, Void , Void> {
        private  NoteDao noteDao;

        public InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDao.insert(noteEntities[0]);
            return null;
        }
    }

    private  static class UpdateNoteAsyncTask extends AsyncTask<NoteEntity, Void , Void> {
        private  NoteDao noteDao;

        public UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDao.update(noteEntities[0]);
            return null;
        }
    }

    private  static class DeleteNoteAsyncTask extends AsyncTask<NoteEntity, Void , Void> {
        private  NoteDao noteDao;

        public DeleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDao.delete(noteEntities[0]);
            return null;
        }
    }

    private  static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void , Void> {
        private  NoteDao noteDao;

        public DeleteAllNotesAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }


}
