package com.example.wirtualnydziennik.teacher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.EditNotesActivity;
import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NoteActivityTeacher extends AppCompatActivity implements AddNotesAdapter.OnNoteListenerNote{

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    AddNotesAdapter notesAdapter;
    ArrayList<User> list;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_teacher);

        recyclerView = findViewById(R.id.userListNoteTeacher);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        notesAdapter = new AddNotesAdapter(this,list,this);
        recyclerView.setAdapter(notesAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                notesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public void onNoteClickNote(int position, String userId) {
        list.get(position);
        Intent intent = new Intent(this, EditNotesActivity.class);
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