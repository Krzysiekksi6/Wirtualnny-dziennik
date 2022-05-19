package com.example.wirtualnydziennik.teacher;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.R;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateStudentGrade extends AppCompatActivity {

    private TextView textView;
    private EditText addGradeEditText;
    private Button applyGradeButton;
    private String subjectId;
    FirebaseFirestore db;
    DocumentReference gradeRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_grade);

        textView = findViewById(R.id.addGradeTv);
        addGradeEditText = findViewById(R.id.enterGradeEditText);
        applyGradeButton = findViewById(R.id.addGradeButton);
        subjectId = loadData();
        db = FirebaseFirestore.getInstance();
        gradeRef = db.collection("Users").document("SfzLVwYSwVTARU3DLqIOhBNrEga2").collection("Grades").document("Mobilki");
        applyGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newGrade = addGradeEditText.getText().toString();
                UpdateData(newGrade);
            }
        });

    }

    private void UpdateData(String newGrade) {
//        Map<String,Object> gradeDetails = new HashMap<>();
//        gradeDetails.
//        gradeRef.update("whichClassId", FieldValue.arrayUnion(newGrade));
    }

    private String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
        return sharedPreferences.getString("ID_TEACHER", "Mobilki");
    }
}