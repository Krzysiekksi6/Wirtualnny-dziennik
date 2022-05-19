package com.example.wirtualnydziennik.teacher;

import static android.content.ContentValues.TAG;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

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

        ArrayList<String> lista = new ArrayList<>();
        gradeRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    if (documentSnapshot.exists()) {
                        gradeRef.update("whichClassId",documentSnapshot.get("whichClassId").toString() + "," +
                                newGrade);
                    }else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });





    }

    private String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
        return sharedPreferences.getString("ID_TEACHER", "Mobilki");
    }
}