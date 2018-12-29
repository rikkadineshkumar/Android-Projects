package com.nist.sankalp2k18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    private RadioGroup radioGroup1,radioGroup2,radioGroup3;
    private RadioButton radioButton1,radioButton2,radioButton3;
    private Button submit;
    private EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().hide();
        submit=(Button)findViewById(R.id.button);
        editText1=(EditText)findViewById(R.id.editText2);
        editText2=(EditText)findViewById(R.id.editText3);
        radioGroup1=(RadioGroup)findViewById(R.id.rg1);
        radioGroup2=(RadioGroup)findViewById(R.id.rg2);
        radioGroup3=(RadioGroup)findViewById(R.id.rg3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId1=radioGroup1.getCheckedRadioButtonId();
                radioButton1=(RadioButton)findViewById(selectedId1);
                int selectedId2=radioGroup2.getCheckedRadioButtonId();
                radioButton2=(RadioButton)findViewById(selectedId2);
                int selectedId3=radioGroup3.getCheckedRadioButtonId();
                radioButton3=(RadioButton)findViewById(selectedId3);
                Toast.makeText(FeedbackActivity.this,"Thanks For Feedback\n"+radioButton1.getText().toString()
                        +radioButton2.getText().toString()+radioButton3.getText().toString()
                        +"\n"+editText1.getText().toString()
                        +"\n"+editText2.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
