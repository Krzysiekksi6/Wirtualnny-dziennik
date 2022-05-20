package com.example.wirtualnydziennik.teacher;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.Subject;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class EditGradesActivity extends AppCompatActivity implements EditGradeAdapter.OnGradeListener {

    RecyclerView recyclerView;
    FirebaseFirestore db;
    EditGradeAdapter myAdapter;
    ArrayList<Subject> list;
    ProgressDialog progressDialog;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_grades);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        recyclerView = findViewById(R.id.gradesListEdit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        list = new ArrayList<Subject>();
        myAdapter = new EditGradeAdapter(EditGradesActivity.this,list,this);
        recyclerView.setAdapter(myAdapter);
        userId = loadData();
        EvenChangeListener();

    }

    private void EvenChangeListener() {

        db.collection("Users").document(userId).collection("Grades")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
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
                                list.add(dc.getDocument().toObject(Subject.class));
                            }
                            myAdapter.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }

    private String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
        return sharedPreferences.getString("ID_TEACHER", "keAu1gFOwuROIjWJvS1nWtKBXya2");
    }


    @Override
    public void onGradeClick(int position, String subjectId) {
        list.get(position);
        Intent intent = new Intent(this, UpdateStudentGrade.class);
        intent.putExtra("SUBJECT_ID", subjectId);
        intent.putExtra("USER_ID", userId);
        startActivity(intent);
//        sharedDataId(subjectId, userId);


        //TODO odbieranie subjectId (ID w firestore == nazwa przedmiotu)
    }

//    public void sharedDataId(String subjectId, String userId){
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences teacher", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("ID_UPDATE_GRADE_TEACHER",);
//        editor.apply();
//    }


}