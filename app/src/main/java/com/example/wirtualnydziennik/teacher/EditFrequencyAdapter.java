package com.example.wirtualnydziennik.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.model.Frequency;

import java.util.ArrayList;

public class EditFrequencyAdapter extends RecyclerView.Adapter<EditFrequencyAdapter.EditFrequencyViewHolder> {
    private Context context;
    private ArrayList<Frequency> subjectArrayList;
    private OnEditFrequencyListener mOnFrequencyListener;

    public EditFrequencyAdapter(Context context, ArrayList<Frequency> list, OnEditFrequencyListener onEditFrequencyListener) {
        this.context = context;
        this.subjectArrayList = list;
        this.mOnFrequencyListener = onEditFrequencyListener;
    }

    @NonNull
    @Override
    public EditFrequencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_edit_frequency_teacher,parent,false);
        return new EditFrequencyViewHolder(v,mOnFrequencyListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EditFrequencyViewHolder holder, int position) {
        Frequency subject = subjectArrayList.get(position);
        holder.date.setText(subject.getDate());
        holder.dayOfWeek.setText(subject.getDayOfWeek());
        holder.numberLesson.setText(subject.getNumberLesson());
        holder.status.setText(subject.getStatus());
        holder.teacher.setText(subject.getTeacherFrequency());
        holder.time.setText(subject.getTime());
    }

    @Override
    public int getItemCount() {
        return subjectArrayList.size();
    }

    public static class EditFrequencyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView date, dayOfWeek, numberLesson, status, teacher, time;
        OnEditFrequencyListener onGradeListener;

        public EditFrequencyViewHolder(@NonNull View itemView ,OnEditFrequencyListener onGradeListener) {
            super(itemView);
            date = itemView.findViewById(R.id.tvDate);
            dayOfWeek = itemView.findViewById(R.id.tvDayOfWeek);
            numberLesson = itemView.findViewById(R.id.tvNumberLesson);
            status = itemView.findViewById(R.id.tvStatus);
            teacher = itemView.findViewById(R.id.tvTeacherName);
            time = itemView.findViewById(R.id.tvTime);

            this.onGradeListener = onGradeListener;

            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String subjectId = numberLesson.getText().toString();
            onGradeListener.onFrequencyClick(getAdapterPosition(),subjectId);
        }
    }

    public interface OnEditFrequencyListener {
        void onFrequencyClick(int position, String subjectId);
    }
}
