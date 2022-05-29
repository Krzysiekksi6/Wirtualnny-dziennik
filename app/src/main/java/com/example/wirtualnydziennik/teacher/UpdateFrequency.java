package com.example.wirtualnydziennik.teacher;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.SharedPreferences;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class UpdateFrequency extends AppCompatActivity {

    private TextView date,dayOfWeek,numberLesson,status,teacher,time;
    private EditText enterStatus, enterLesson, enterTime,enterTeacherName;
    private Button confirmButton;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String userId, dateString, dayOfWeekString,
            numberLessonString, statusString, teacherString, timeString;
    private Context context;
    private int duration = Toast.LENGTH_LONG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_frequency);
        initVariables();
        context = getApplicationContext();
        userId = loadData();
        initVariables();
        getDataFromUser();

    }

    private void getDataFromUser() {
        if (!date.getText().toString().isEmpty() && !dayOfWeek.getText().toString().isEmpty() &&
        !numberLesson.getText().toString().isEmpty() && !status.getText().toString().isEmpty() &&
        !teacher.getText().toString().isEmpty() && !time.getText().toString().isEmpty()) {
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dateString = date.getText().toString();
                    dayOfWeekString = dayOfWeek.getText().toString();
                    numberLessonString = numberLesson.getText().toString();
                    statusString = status.getText().toString();
                    teacherString = teacher.getText().toString();
                    timeString = time.getText().toString();
                    updateDb();
                    Toast.makeText(context, "SUCCESS", duration).show();
                }
            });
        } else {
            Toast.makeText(context, "Data cannot be EMPTY", duration);
        }
    }

    private String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher frequency", MODE_PRIVATE);
        return sharedPreferences.getString("ID_TEACHER_NOTE", "keAu1gFOwuROIjWJvS1nWtKBXya2");
    }

    private void updateDb(){
        Map<String,Object> map = new HashMap<>();
        map.put("date", dateString);
        map.put("dayOfWeek", dayOfWeekString);
        map.put("numberLesson", numberLessonString);
        map.put("status", statusString);
        map.put("teacher", teacherString);
        map.put("time", timeString);
        db.collection("Users").document(userId).collection("Frequency")
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


    private void initVariables() {
        String currentDayOfWeek = LocalDate.now().getDayOfWeek().name();
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        numberLesson = findViewById(R.id.tvSelectLesson);
        status = findViewById(R.id.tvStatusFrequency);
        teacher = findViewById(R.id.tvTeacherNameFrequency);
        time = findViewById(R.id.tvTimeFrequency);
        confirmButton = findViewById(R.id.confirm_button_frequency);
        dayOfWeek = findViewById(R.id.tvCurrentDayFrequency);
        date = findViewById(R.id.tvCurrentDateFrequency);
        date.setText(currentDate);
        dayOfWeek.setText(currentDayOfWeek.substring(0,1).toUpperCase(Locale.ROOT) + currentDayOfWeek.substring(1).toLowerCase(Locale.ROOT));

    }
}