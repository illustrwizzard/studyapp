package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

public class profilePersonalDetails extends AppCompatActivity {
    EditText date1;
    DatePickerDialog datePickerDialog1;
    RadioGroup radioGroup;
    Spinner spinner,spinner1;
    String nationality="",bloodgroup="";
    String[] ChooseBoard={"CBSE","ICSE","State Board"};
    String[] ChooseBoard1={"CBSE","ICSE","State Board"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_personal_details);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        spinner=findViewById(R.id.sp1);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton)radioGroup.findViewById(i);


            }
        });


        date1=findViewById(R.id.pppp55);
        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog1 = new DatePickerDialog(profilePersonalDetails.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date1.setText(i2 + "/"
                                + (i1 + 1) + "/" + i);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog1.show();
            }
        });


        spinnerAdapter a = new spinnerAdapter(profilePersonalDetails.this, android.R.layout.simple_list_item_1);
        a.addAll(ChooseBoard);
        a.add("Nationality");
        spinner.setAdapter(a);
        spinner.setSelection(a.getCount());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner.getSelectedItem() == "Nationality")
                {

                }
                else{

                    nationality= String.valueOf(adapterView.getItemAtPosition(i));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

          spinner1=findViewById(R.id.sp2);
        spinnerAdapter a1 = new spinnerAdapter(profilePersonalDetails.this, android.R.layout.simple_list_item_1);
        a1.addAll(ChooseBoard1);
        a1.add("Blood group");
        spinner1.setAdapter(a1);
        spinner1.setSelection(a1.getCount());
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner1.getSelectedItem() == "Blood group")
                {

                }
                else{

                    bloodgroup= String.valueOf(adapterView.getItemAtPosition(i));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}