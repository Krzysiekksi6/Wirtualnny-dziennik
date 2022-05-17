package com.example.wirtualnydziennik.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.User;

import java.util.ArrayList;

public class AddGradesAdapter extends RecyclerView.Adapter<AddGradesAdapter.GradeViewHolder> {
    Context contexte;
    ArrayList<User> list;

    public AddGradesAdapter(Context context, ArrayList<User> list) {
        this.contexte = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexte).inflate(R.layout.item_add_grades_teacher,parent,false);
        return new GradeViewHolder(v);
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

    public static class GradeViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, lastName, email, id;

        public GradeViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tvFirstNameStudentItem);
            lastName = itemView.findViewById(R.id.tvLastNameStudentItem);
            email = itemView.findViewById(R.id.tvEmailStudentItem);
            id = itemView.findViewById(R.id.tvIdStudentItem);
        }
    }
}
