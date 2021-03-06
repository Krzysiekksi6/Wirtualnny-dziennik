package com.example.wirtualnydziennik.student;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wirtualnydziennik.EditFrequencyActivity;
import com.example.wirtualnydziennik.FaqActivity;
import com.example.wirtualnydziennik.GradesActivity;
import com.example.wirtualnydziennik.NoteActivityStudnet;
import com.example.wirtualnydziennik.R;

/**
 * Menu Glowne Aplikacji
 * Uprawnienia: Uczen
 */

public class MainActivityList extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        toolbar = findViewById(R.id.ToolbarMain);
        initToolbar();
        setupListView();
    }


    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WD Student Application");
    }

    private void setupListView(){
        String [] title = getResources().getStringArray(R.array.Main_Student);
        String [] description = getResources().getStringArray(R.array.Description_Student);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        ListView listView = (ListView) findViewById(R.id.lvMain);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(MainActivityList.this, WeekActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(MainActivityList.this, SubjectActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 2: {
                        Intent intent = new Intent(MainActivityList.this, GradesActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 3: {
                        Intent intent = new Intent(MainActivityList.this, NoteActivityStudnet.class);
                        startActivity(intent);
                        break;
                    }

                    case 4: {
                        Intent intent = new Intent(MainActivityList.this, EditFrequencyActivity.class);
                        startActivity(intent);
                        break;
                    }


                    case 5: {
                        Intent intent = new Intent(MainActivityList.this, FaqActivity.class);
                        startActivity(intent);
                        break;
                    }

                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] titleArray, String[] descriptionArray) {
            mContext = context;
            this.titleArray = titleArray;
            this.descriptionArray = descriptionArray;
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
                convertView = layoutInflater.inflate(R.layout.activity_main_single_item, null);
            }
            title = (TextView)convertView.findViewById(R.id.tvMain);
            description = (TextView)convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView)convertView.findViewById(R.id.ivMain);
            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.schedulde_logo);
            }else if(titleArray[position].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.books_logo);
            }else if(titleArray[position].equalsIgnoreCase("Grades")){
                imageView.setImageResource(R.drawable.grade_logo);
            }else if (titleArray[position].equalsIgnoreCase("Note")) {
                imageView.setImageResource(R.drawable.note);
            } else if (titleArray[position].equalsIgnoreCase("Frequency")) {
                imageView.setImageResource(R.drawable.fr);
            }
            else{
                imageView.setImageResource(R.drawable.faqs);
            }
            return convertView;
        }
    }
}