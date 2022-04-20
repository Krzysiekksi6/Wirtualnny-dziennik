package com.example.wirtualnydziennik;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wirtualnydziennik.Utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private String[] subjects;
    public static SharedPreferences subjectPreferences;
    public static String SUB_PREF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setupUIViews();
        initToolbar();
        setupListView();

    }

    private void setupUIViews(){
        toolbar = findViewById(R.id.ToolbarSubject);
        listView = (ListView) findViewById(R.id.lvSubject);
        subjectPreferences = getSharedPreferences("Subjects", MODE_PRIVATE);

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView() {
        subjects = getResources().getStringArray(R.array.Subjects);

        SubjectAdapter subjectAdapter = new SubjectAdapter(this, R.layout.subject_single_item, subjects);
        listView.setAdapter(subjectAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        subjectPreferences.edit().putString(SUB_PREF,"Algorithms").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        subjectPreferences.edit().putString(SUB_PREF,"Algebra").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 2:{
                        subjectPreferences.edit().putString(SUB_PREF,"Numerical Methods").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 3: {
                        subjectPreferences.edit().putString(SUB_PREF,"Dynamic Systems").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 4: {
                        subjectPreferences.edit().putString(SUB_PREF,"Mobile Programing").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 5: {
                        subjectPreferences.edit().putString(SUB_PREF,"Big Data").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 6: {
                        subjectPreferences.edit().putString(SUB_PREF,"Web Technologies").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 7: {
                        subjectPreferences.edit().putString(SUB_PREF,"Operation Research").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 8: {
                        subjectPreferences.edit().putString(SUB_PREF,"Distributed Systems").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 9: {
                        subjectPreferences.edit().putString(SUB_PREF,"Mathematical Analysis").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }

                    case 10: {
                        subjectPreferences.edit().putString(SUB_PREF,"WF").apply();
                        Intent intent = new Intent(SubjectActivity.this, SubjectDetail.class);
                        startActivity(intent);
                    }



                    default:
                        break;
                }
            }
        });
    }

    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subject = new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subject = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource,null);
                holder.ivLogo = (LetterImageView) convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject = (TextView) convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(subjects[position].charAt(0));
            holder.tvSubject.setText(subjects[position]);
            return convertView;
        }
        class ViewHolder{
            public TextView tvSubject;
            private LetterImageView ivLogo;


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