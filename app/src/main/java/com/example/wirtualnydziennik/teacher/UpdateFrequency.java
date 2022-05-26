package com.example.wirtualnydziennik.teacher;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.R;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class UpdateFrequency extends AppCompatActivity {

    private TextView date,dayOfWeek,numberLesson,status,teacher,time;
    private EditText enterStatus, enterLesson, enterTime,enterTeacherName;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_frequency);
        initVariables();


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
        dayOfWeek.setText(currentDayOfWeek);

    }
}