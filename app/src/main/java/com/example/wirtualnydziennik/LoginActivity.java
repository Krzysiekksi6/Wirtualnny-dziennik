package com.example.wirtualnydziennik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private TextView titleTextView, registerTextView, forgotPasswordTextView;
    private ImageView logoImageView;
    private Button loginButton;
    private EditText userEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        titleTextView = findViewById(R.id.title_text_view);
        registerTextView = findViewById(R.id.register_text_view);
        forgotPasswordTextView = findViewById(R.id.forgot_password_text_view);
        logoImageView = findViewById(R.id.avatar_image_view);
        loginButton = findViewById(R.id.login_button);
        userEditText = findViewById(R.id.user_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userEditText.getText().toString();
                String password = passwordEditText.getText().toString();
            }
        });
    }
}