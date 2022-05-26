package com.example.wirtualnydziennik.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.model.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private Context context;
    private ArrayList<Note> list;

    public NoteAdapter(Context context, ArrayList<Note> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_note_adapter,parent,false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = list.get(position);
        holder.category.setText(note.getCategory());
        holder.content.setText(note.getContent());
        holder.date.setText(note.getDate());
        holder.teacher.setText(note.getTeacherNote());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView category, content, date, teacher;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.tvCategoryNoteStudent);
            content = itemView.findViewById(R.id.tvContentNoteStudent);
            date = itemView.findViewById(R.id.tvDateNoteStudent);
            teacher = itemView.findViewById(R.id.tvTeacherNameNoteStudent);
        }
    }
}
