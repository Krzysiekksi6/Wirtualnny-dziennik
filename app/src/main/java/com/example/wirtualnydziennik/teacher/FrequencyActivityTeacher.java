package com.example.wirtualnydziennik.teacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.EditFrequencyActivity;
import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FrequencyActivityTeacher extends AppCompatActivity implements AddFrequencyAdapter.OnNoteListenerFrequency{

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    AddFrequencyAdapter frequencyAdapter;
    ArrayList<User> list;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequency_teacher);

        recyclerView = findViewById(R.id.userListFrequencyTeacher);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        frequencyAdapter = new AddFrequencyAdapter(this,list,this);
        recyclerView.setAdapter(frequencyAdapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                frequencyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onNoteClickFrequency(int position, String userId) {
        list.get(position);
        Intent intent = new Intent(this, UpdateFrequency.class);
        sharedUserIdFrequency(userId);
        startActivity(intent);

    }

    public void sharedUserIdFrequency(String userId){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher frequency", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ID_TEACHER_FREQUENCY", userId);
        editor.apply();
    }


    }
