package com.example.wirtualnydziennik;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.model.Frequency;
import com.example.wirtualnydziennik.teacher.EditFrequencyAdapter;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class EditFrequencyActivity extends AppCompatActivity implements EditFrequencyAdapter.OnEditFrequencyListener{

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private EditFrequencyAdapter myAdapter;
    private ArrayList<Frequency> list;
    private ProgressDialog progressDialog;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_frequency);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();
        recyclerView = findViewById(R.id.frequencyListEdit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        list = new ArrayList<Frequency>();
        myAdapter = new EditFrequencyAdapter(EditFrequencyActivity.this,list,this);
        recyclerView.setAdapter(myAdapter);
        userId = loadData();
        EvenChangeListener();

    }

    private void EvenChangeListener() {

        db.collection("Users").document(userId).collection("Frequency")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error!=null) {
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for(DocumentChange dc: value.getDocumentChanges()) {
                            if(dc.getType() == DocumentChange.Type.ADDED) {
                                list.add(dc.getDocument().toObject(Frequency.class));
                            }
                            myAdapter.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }
    private String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("Shared Preferences Student ID", MODE_PRIVATE);
        return sharedPreferences.getString("STUDENT_LOGGED_ID", "keAu1gFOwuROIjWJvS1nWtKBXya2");
    }

    @Override
    public void onFrequencyClick(int position, String subjectId) {
        list.get(position);
        Intent intent = new Intent(this, FaqActivity.class);
        //intent.putExtra("SUBJECT_ID", subjectId);
        //intent.putExtra("USER_ID", userId);
        startActivity(intent);
    }
}