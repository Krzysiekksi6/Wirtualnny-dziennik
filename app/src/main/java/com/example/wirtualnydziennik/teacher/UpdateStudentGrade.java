package com.example.wirtualnydziennik.teacher;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 *
 * Klasa obslugujaca dodawanie ocen do FireStore
 * Uprawnienia do tej Klasy posiada tylko Profesor
 *
 */

public class UpdateStudentGrade extends AppCompatActivity {

    private Context context;
    private int duration;
    private final String ADD_GRADE = "Grade has been added";
    private EditText addGradeEditText;
    private Button applyGradeButton;
    private Intent intent;
    private String subjectId;
    private String userId;
    private FirebaseFirestore db;
    private DocumentReference gradeRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student_grade);
        intent = getIntent();
        context = getApplicationContext();
        duration = Toast.LENGTH_SHORT;
        addGradeEditText = findViewById(R.id.enterGradeEditText);
        applyGradeButton = findViewById(R.id.addGradeButton);
        userId = intent.getStringExtra("USER_ID");
        subjectId = intent.getStringExtra("SUBJECT_ID");
        db = FirebaseFirestore.getInstance();
        gradeRef = db.collection("Users").document(userId).collection("Grades").document(subjectId);


        applyGradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newGrade = addGradeEditText.getText().toString();
                UpdateData(newGrade);
                Toast.makeText(context, newGrade + ": " + ADD_GRADE, duration).show();

            }
        });

    }

    private void UpdateData(String newGrade) {

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

//    private String loadUserId() {
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
//        return sharedPreferences.getString("ID_USER", "Mobilki");
//    }

    private String loadSubjectId() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
        return sharedPreferences.getString("ID_UPDATE_GRADE_TEACHER", "Mobilki");
    }
}