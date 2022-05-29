package com.example.wirtualnydziennik.model;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wirtualnydziennik.R;
import com.example.wirtualnydziennik.student.SubjectActivity;

public class SubjectDetail extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = findViewById(R.id.ToolbarSubjectDetails);
        listView = (ListView) findViewById(R.id.lvSubjectDetails);

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        String subject_selected = SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PREF, null);
        String[] syllabus = new String[] {};
        String[] titles = getResources().getStringArray(R.array.titles);

        if (subject_selected.equalsIgnoreCase("Algorithms")) {
            syllabus = getResources().getStringArray(R.array.Algorithms);
        } else if (subject_selected.equalsIgnoreCase("Algebra")) {
            syllabus = getResources().getStringArray(R.array.Algebra);
        } else if (subject_selected.equalsIgnoreCase("Numerical Methods")) {
            syllabus = getResources().getStringArray(R.array.Numerical_Methods);
        } else if (subject_selected.equalsIgnoreCase("Dynamic Systems")) {
            syllabus = getResources().getStringArray(R.array.Dynamic_Systems);
        }else if (subject_selected.equalsIgnoreCase("Mobile Programing")) {
            syllabus = getResources().getStringArray(R.array.Mobile_Programing);
        }else if (subject_selected.equalsIgnoreCase("Big Data")) {
            syllabus = getResources().getStringArray(R.array.Big_Data);
        }else if (subject_selected.equalsIgnoreCase("Web Technologies")) {
            syllabus = getResources().getStringArray(R.array.Web_Technoliges);
        }else if (subject_selected.equalsIgnoreCase("Operation Research")) {
            syllabus = getResources().getStringArray(R.array.Operation_Research);
        }else if (subject_selected.equalsIgnoreCase("Distributed Systems")) {
            syllabus = getResources().getStringArray(R.array.Distributed_Systems);
        }else if (subject_selected.equalsIgnoreCase("Mathematical Analysis")) {
            syllabus = getResources().getStringArray(R.array.Mathematical_Analysis);
        }
        else {
            syllabus = getResources().getStringArray(R.array.WF);
        }

        SubjectDetailsAdapter subjectDetailsAdapter = new SubjectDetailsAdapter(this, titles, syllabus);
        listView.setAdapter(subjectDetailsAdapter);
    }

    public class SubjectDetailsAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, syllabus;
        private String[] titleArray;
        private String[] syllabusArray;


        public SubjectDetailsAdapter(Context context, String[] titleArray, String[] descriptionArray) {
            mContext = context;
            this.titleArray = titleArray;
            this.syllabusArray = descriptionArray;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.subject_details_single_item, null);
            }
            title = (TextView)convertView.findViewById(R.id.tvSubjectTitle);
            syllabus = (TextView)convertView.findViewById(R.id.tvSyllabus);
            title.setText(titleArray[position]);
            syllabus.setText(syllabusArray[position]);


            return convertView;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}