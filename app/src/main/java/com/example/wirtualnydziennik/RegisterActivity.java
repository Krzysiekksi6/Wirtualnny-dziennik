package com.example.wirtualnydziennik;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private ImageView avatarImageView;
    private EditText locationEditText, phoneEditText, nameEditText, passwordEditText, emailEditText;
    private CheckBox studentCheckBox, professorCheckBox;
    private Button registerButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        avatarImageView = findViewById(R.id.avatar_image_view);
        locationEditText = findViewById(R.id.location_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        nameEditText = findViewById(R.id.name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        studentCheckBox = findViewById(R.id.student_check_box);
        professorCheckBox = findViewById(R.id.professor_check_box);
        registerButton = findViewById(R.id.register_button);



    }
}
