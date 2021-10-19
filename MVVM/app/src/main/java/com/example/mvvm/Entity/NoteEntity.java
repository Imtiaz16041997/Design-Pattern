package com.example.mvvm.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class NoteEntity {

    @PrimaryKey(autoGenerate = true)
    private  String id;

    private String title;

    private String description;
    @ColumnInfo(name = "priority_column")
    private int priority;

    public NoteEntity(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
