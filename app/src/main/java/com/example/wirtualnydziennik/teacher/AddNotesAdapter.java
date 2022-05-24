package com.example.wirtualnydziennik.teacher;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.model.User;

import java.util.ArrayList;

public class AddNotesAdapter extends RecyclerView.Adapter<AddNotesAdapter.NoteViewHolder> {

    private Context context;
    private ArrayList<User> list;
    private OnNoteListenerNote mOnNoteListener;

    public AddNotesAdapter(Context context, ArrayList<User> list, OnNoteListenerNote onNoteListener) {
        this.context = context;
        this.list = list;
        this.mOnNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_add_grades_teacher,parent,false);
        NoteViewHolder gradeViewHolder = new NoteViewHolder(v,mOnNoteListener);
        return gradeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        User user = list.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.email.setText(user.getEmail());
        holder.id.setText(user.getId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView firstName, lastName, email, id;
        AddNotesAdapter.OnNoteListenerNote onNoteListener;
        public NoteViewHolder(@NonNull View itemView, OnNoteListenerNote onNoteListener) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tvFirstNameStudentItem);
            lastName = itemView.findViewById(R.id.tvLastNameStudentItem);
            email = itemView.findViewById(R.id.tvEmailStudentItem);
            id = itemView.findViewById(R.id.tvIdStudentItem);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String userId = id.getText().toString();
            onNoteListener.onNoteClickNote(getAdapterPosition(), userId);
        }
    }
    public interface OnNoteListenerNote {
        void onNoteClickNote(int position, String userId);
    }
}
