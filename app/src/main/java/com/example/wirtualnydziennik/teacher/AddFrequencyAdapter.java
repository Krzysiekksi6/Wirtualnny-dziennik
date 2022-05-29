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

public class AddFrequencyAdapter extends RecyclerView.Adapter<AddFrequencyAdapter.FrequencyViewHolder> {

    private Context context;
    private ArrayList<User> list;
    private OnNoteListenerFrequency mOnNoteListener;

    public AddFrequencyAdapter(Context context, ArrayList<User> list, OnNoteListenerFrequency onNoteListener) {
        this.context = context;
        this.list = list;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public FrequencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_add_grades_teacher,parent,false);
        FrequencyViewHolder gradeViewHolder = new FrequencyViewHolder(v,mOnNoteListener);
        return gradeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FrequencyViewHolder holder, int position) {
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

    public class FrequencyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView firstName, lastName, email, id;
        OnNoteListenerFrequency onNoteListener;
        public FrequencyViewHolder(@NonNull View itemView, OnNoteListenerFrequency onNoteListener) {
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
            onNoteListener.onNoteClickFrequency(getAdapterPosition(), userId);
        }
    }
    public interface OnNoteListenerFrequency {
        void onNoteClickFrequency(int position, String userId);
    }
}
