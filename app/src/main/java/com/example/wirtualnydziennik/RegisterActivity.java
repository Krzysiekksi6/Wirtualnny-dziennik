package com.example.wirtualnydziennik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText locationEditText, phoneEditText, nameEditText, passwordEditText, emailEditText,lastNameEditText;
    private ImageView avatarImageView;
    private Button registerButton;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private User user;
    private RadioGroup rg;
    private RadioButton studentBut;
    private RadioButton profBut;
    private String status = null;
    private static final String USER = "user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rg = findViewById(R.id.rg);
        locationEditText = findViewById(R.id.location_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        nameEditText = findViewById(R.id.name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        profBut = findViewById(R.id.profesorButton);
        studentBut = findViewById(R.id.studentButton);
        avatarImageView = findViewById(R.id.avatar_image_view);
        registerButton = findViewById(R.id.choose_class);
        lastNameEditText = findViewById(R.id.last_name_edit_text);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Enter email and password",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                String firstName = nameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                Boolean isProfessor = checkStatus();
                String location = locationEditText.getText().toString();
                String phoneNumber = phoneEditText.getText().toString();
                //TODO Ogarnąc checkboxy student i profesor i zaimplemenować odpowiednia zależność if ---> zrobiłem
                // TODO w konstruktorze User jest atrubut boolean isProfessor; ???
                // TODO jesli checkobx jest klikniety na profesora to ustalamy w konstruktorze warotsc true
                // TODO Prawdopodobnie do checkboxa trzeba dodać tą sama radioGrupe czy cos takiego zeby mozna było tylko jedna opcje zaznaczyc
                // TODO w LOGIN ACTIVITY pod przyciskiem login masz register (text view) po nacisnieciu textview ma byc zmiana activity na Register Activity
                // TODO najlepiej zrobic najprosteszym intentem ktorego masz w 108 linice kodu na dole

                 user = new User(email,password,firstName,lastName,location,phoneNumber,isProfessor);
                registerUser(email,password);


            }
        });

        studentBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status = "student";
            }
        });



        profBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status = "professor";
            }
        });

    }
    public void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("sucess", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Failed", "signInWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    public void updateUI(FirebaseUser currentUser){
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(user);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    public void checkPull(){
    }

    public Boolean checkStatus(){
        if(status.contains("professor")){
            return true;
        }
        else {
            return false;
        }
    }





}