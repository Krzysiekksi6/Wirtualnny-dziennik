package com.example.wirtualnydziennik.teacher;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.R;

public class UpdateStudentGrade extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_grade);

        textView = findViewById(R.id.addGradeTv);
        editText = findViewById(R.id.enterGradeEditText);
        button = findViewById(R.id.addGradeButton);

    }
}