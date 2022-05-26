package com.example.wirtualnydziennik.teacher;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class UpdateNote extends AppCompatActivity {
    private TextView category,content,date,teacher;
    private EditText enterCategory, enterContent, enterTeacherName;
    private Button confirmButton;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String userId, categoryString, contentString, dateString, teacherString;
    private Context context = getApplicationContext();
    private int duration = Toast.LENGTH_SHORT;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        userId = loadData();
        initVariables();
        getDataFromUser();


    }

    private void getDataFromUser() {

        if (!category.getText().toString().isEmpty() && !content.getText().toString().isEmpty() &&
        !date.getText().toString().isEmpty() && !teacher.getText().toString().isEmpty()) {
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categoryString = category.getText().toString();
                    contentString = content.getText().toString();
                    dateString = date.getText().toString();
                    teacherString = teacher.getText().toString();
                    updateDb();
                    Toast.makeText(context, "SUCCESS", duration);
                }
            });
        } else {
            Toast.makeText(context, "Data cannot be EMPTY", duration);
        }
    }

    private void updateDb() {
        Map<String,Object> map = new HashMap<>();
        map.put("category", categoryString);
        map.put("content", contentString);
        map.put("date", dateString);
        map.put("teacher", teacherString);
        db.collection("Users").document(userId).collection("Note")
                .add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "onSuccess Update Note");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "NOT onSuccess Update Note");
                    }
                });
    }

    //TODO userID
    private String loadData() {
        return "SfzLVwYSwVTARU3DLqIOhBNrEga2";
    }

    private void initVariables() {
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        date = findViewById(R.id.tvDateNote);
        category = findViewById(R.id.tvCategoryNote);
        content = findViewById(R.id.tvContentNote);
        teacher = findViewById(R.id.tvTeacherNameNote);
        enterCategory = findViewById(R.id.editTextCategoryNote);
        enterContent = findViewById(R.id.editTextContentNote);
        enterTeacherName = findViewById(R.id.editTextTeacherNameNote);
        confirmButton = findViewById(R.id.confirm_button_note);
        date.setText(currentDate);
    }
}