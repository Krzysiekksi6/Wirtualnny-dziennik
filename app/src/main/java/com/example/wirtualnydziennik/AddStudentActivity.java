package com.example.wirtualnydziennik;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {

    AlertDialog alertDialog1;
    Button button2;
    Button button3;
    TextView textView1;
    CharSequence[] values1 = {" 1 "," 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 1(HIGHSCHOOL) " , " 2(HIGHSCHOOL) "," 3(HIGHSCHOOL) ", " 4(HIGHSCHOOL) "," 5(HIGHSCHOOL(TECH)) "};
    CharSequence[] values2 = {" A "," B "," C "," D "," E "};
    String save;
    int yearTimesCounter = 0;
    int typeTimesCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        button2 = findViewById(R.id.choose_class);
        button3 = findViewById(R.id.choose_class2);
        textView1 = findViewById(R.id.chooseclassyearText);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateAlertDialogWithRadioButtonGroup(values1,"Select year") ;

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialogWithRadioButtonGroup(values2,"Select class type");
            }
        });
    }

    public void CreateAlertDialogWithRadioButtonGroup(CharSequence[] Values,String textOption){

        AlertDialog.Builder builder = new AlertDialog.Builder(AddStudentActivity.this);

        builder.setTitle(textOption);

        builder.setSingleChoiceItems(Values, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(AddStudentActivity.this, "Clicked "+Values[item], Toast.LENGTH_LONG).show();
                if((yearTimesCounter == 0 && typeTimesCounter == 0) || (yearTimesCounter==1 && typeTimesCounter==0)) {
                    String stringToConvert = String.valueOf(Values[item]);
                    textView1.setText(textView1.getText()+stringToConvert);
                    alertDialog1.dismiss();
                    if(yearTimesCounter==1){
                        typeTimesCounter=1;
                    }
                    else{
                        yearTimesCounter=1;
                    }
                }
                else{
                    Toast.makeText(AddStudentActivity.this, "Clicked first year ", Toast.LENGTH_LONG).show();
                    typeTimesCounter=0;
                    yearTimesCounter=0;
                    textView1.setText("");
                    save = "";
                    alertDialog1.dismiss();

                }
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

    }
}