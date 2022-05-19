package com.example.wirtualnydziennik.teacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.LoginActivity;
import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GradesActivityTeacher extends AppCompatActivity implements AddGradesAdapter.OnNoteListener {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    AddGradesAdapter gradeAdapter;
    private RecyclerView.LayoutManager layoutManagerRecyclerView;
    ArrayList<User> list;
    TextView textView;
    LoginActivity loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_teacher);

        recyclerView = findViewById(R.id.userListTeacher);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        gradeAdapter = new AddGradesAdapter(this,list,this);
        recyclerView.setAdapter(gradeAdapter);

        textView = findViewById(R.id.tvIdStudentItem);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                gradeAdapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onNoteClick(int position, String userId) {
        list.get(position);
        Intent intent = new Intent(this, EditGradesActivity.class);
        sharedUserId(userId);
        startActivity(intent);

    }

    public void sharedUserId(String userId){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ID_TEACHER", userId);
        editor.apply();
    }
}