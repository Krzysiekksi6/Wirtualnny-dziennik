package com.example.wirtualnydziennik;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class GradesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore db;
    GradeAdapter myAdapter;
    ArrayList<Subject> list;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Fetching Data...");
//        progressDialog.show();


        recyclerView = findViewById(R.id.gradesList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        list = new ArrayList<Subject>();
        myAdapter = new GradeAdapter(GradesActivity.this,list);
        recyclerView.setAdapter(myAdapter);

        EvenChangeListener();

    }

    private void EvenChangeListener() {
        db.collection("subjects")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error!=null) {
//                            if(progressDialog.isShowing())
//                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for(DocumentChange dc: value.getDocumentChanges()) {
                            if(dc.getType() == DocumentChange.Type.ADDED) {
                                list.add(dc.getDocument().toObject(Subject.class));
                            }
                            myAdapter.notifyDataSetChanged();
//                            if(progressDialog.isShowing())
//                                progressDialog.dismiss();
                        }
                    }
                });
    }


}