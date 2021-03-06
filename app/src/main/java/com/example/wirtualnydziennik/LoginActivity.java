package com.example.wirtualnydziennik;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wirtualnydziennik.student.MainActivityList;
import com.example.wirtualnydziennik.teacher.MainActivityTeacher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Klasa obslugujaca Logike Logowania do Aplikacji
 * Uprawnienia: Uczen i Profesor
 */

public class LoginActivity extends AppCompatActivity {
    private TextView titleTextView, registerTextView, forgotPasswordTextView;
    private ImageView logoImageView;
    private Button loginButton;
    private Button registerButton;
    private EditText userEditText, passwordEditText;
    private FirebaseAuth mAuth;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPasswordTextView = findViewById(R.id.forgot_password_text_view);
        logoImageView = findViewById(R.id.avatar_image_view);
        loginButton = findViewById(R.id.login_button);
        userEditText = findViewById(R.id.user_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        mAuth = FirebaseAuth.getInstance();
        registerButton = findViewById(R.id.reg_button);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = userEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("sucess", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    userId = mAuth.getCurrentUser().getUid();
                                    sharedUserId(userId);
                                    //updateUI(user);
                                    if (username.equals("profesor-anstar@edu.pl")) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivityTeacher.class);
                                        startActivity(intent);
                                    } else {
                                        Intent intent = new Intent(LoginActivity.this, MainActivityList.class);
                                        startActivity(intent);
                                    }
                                } else {
                                    // If sign in fails, display a message to the user.
                                    String asd = "fail";
                                    Log.w(asd, "signInWithCustomToken:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
//            updateUI(currentUser);
        }
    }

//    public void updateUI(FirebaseUser currentUser) {
//        Intent profileIntent = new Intent(this, RegisterActivity.class);
//        profileIntent.putExtra("email", currentUser.getEmail());
//        startActivity(profileIntent);
//        //TODO check (isStudent? or isProfessor?)
//        if (currentUser.getEmail().equals("profesor")) {
//
//        }
//    }

    public void sharedUserId(String userId){
        SharedPreferences sharedPreferences = getSharedPreferences("Shared Preferences Student ID", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("STUDENT_LOGGED_ID", userId);
        editor.apply();
    }

}

