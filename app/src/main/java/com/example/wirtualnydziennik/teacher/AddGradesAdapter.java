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

public class AddGradesAdapter extends RecyclerView.Adapter<AddGradesAdapter.GradeViewHolder> {
    private Context contexte;
    private ArrayList<User> list;
    private OnNoteListener mOnNoteListener;



    public AddGradesAdapter(Context context, ArrayList<User> list, OnNoteListener onNoteListener) {
        this.contexte = context;
        this.list = list;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexte).inflate(R.layout.item_add_grades_teacher,parent,false);
        GradeViewHolder gradeViewHolder = new GradeViewHolder(v,mOnNoteListener);
        return gradeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GradeViewHolder holder, int position) {
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


    public static class GradeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView firstName, lastName, email, id;
        OnNoteListener onNoteListener;

        public GradeViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
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
            onNoteListener.onNoteClick(getAdapterPosition(), userId);
        }
    }
    public interface OnNoteListener {
        void onNoteClick(int position, String userId);
    }
}
