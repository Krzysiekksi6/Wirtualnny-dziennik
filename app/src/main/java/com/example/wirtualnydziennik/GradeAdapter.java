package com.example.wirtualnydziennik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GradeAdapter extends RecyclerView.Adapter <GradeAdapter.MyViewHolder>{

    Context context;
    ArrayList<Subject> subjectArrayList;


    public GradeAdapter(Context context, ArrayList<Subject> subjectArrayList) {
        this.context = context;
        this.subjectArrayList = subjectArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.grade_single_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Subject subject = subjectArrayList.get(position);
        holder.subjectName.setText(subject.getNameOfSubject());
        holder.instructorName.setText(subject.getInstructor());
        holder.grades.setText(subject.getWhichClassId());

    }

    @Override
    public int getItemCount() {
        return subjectArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView subjectName, instructorName, grades;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subjectName = itemView.findViewById(R.id.tvSubjectName);
            instructorName = itemView.findViewById(R.id.tvInstructorName);
            grades = itemView.findViewById(R.id.tvGrades);
        }
    }
}
