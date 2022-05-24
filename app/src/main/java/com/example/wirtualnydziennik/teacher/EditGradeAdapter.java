package com.example.wirtualnydziennik.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.model.Subject;

import java.util.ArrayList;

public class EditGradeAdapter extends RecyclerView.Adapter <EditGradeAdapter.EditViewHolder>{
    private Context context;
    private ArrayList<Subject> subjectArrayList;
    private OnGradeListener mOnGradeListener;

    public EditGradeAdapter(Context context, ArrayList<Subject> subjectArrayList, OnGradeListener onGradeListener) {
        this.context = context;
        this.subjectArrayList = subjectArrayList;
        this.mOnGradeListener = onGradeListener;
    }


    @NonNull
    @Override
    public EditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_edit_grade_teacher,parent,false);
        return new EditViewHolder(v, mOnGradeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EditViewHolder hold, int position) {
        Subject subject = subjectArrayList.get(position);
        hold.subjectName.setText(subject.getNameOfSubject().toString());
        hold.instructorName.setText(subject.getInstructor().toString());
        hold.grades.setText(subject.getWhichClassId().toString());

    }

    @Override
    public int getItemCount() {
        return subjectArrayList.size();
    }

    public static class EditViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView subjectName, instructorName, grades;
        OnGradeListener onGradeListener;
        public EditViewHolder(@NonNull View itemView, OnGradeListener onGradeListener) {
            super(itemView);

            subjectName = itemView.findViewById(R.id.tvSubjectNameEdit);
            instructorName = itemView.findViewById(R.id.tvInstructorNameEdit);
            grades = itemView.findViewById(R.id.tvGradesEdit);
            this.onGradeListener = onGradeListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String subjectId = subjectName.getText().toString();
            onGradeListener.onGradeClick(getAdapterPosition(),subjectId);
        }
    }
    public interface OnGradeListener{
        void onGradeClick(int position, String subjectId);
    }


}
