package com.example.mvvm.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.R;

 public  class NoteHolder extends RecyclerView.ViewHolder {
     public TextView textViewTitle;
     public TextView textViewDescription;
     public TextView textViewPriority;

    public NoteHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.text_view_title);
        textViewDescription = itemView.findViewById(R.id.text_view_description);
        textViewPriority = itemView.findViewById(R.id.text_view_priority);

    }

}
