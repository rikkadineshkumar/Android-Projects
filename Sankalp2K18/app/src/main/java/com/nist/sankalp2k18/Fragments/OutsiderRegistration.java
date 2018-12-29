package com.nist.sankalp2k18.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.nist.sankalp2k18.HomeActivity;
import com.nist.sankalp2k18.R;

/**
 * Created by ABHISHEK on 2/23/2018.
 */

public class OutsiderRegistration extends Fragment {

    private Spinner spinner_course,spinner_year;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.outsider_register_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mView = view;
        spinner_course = (Spinner) view.findViewById(R.id.spinner2);
        spinner_year = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter_course = new ArrayAdapter<String>(view.getContext(), R.layout.spinner_textview,getResources().getStringArray(R.array.course));
        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(view.getContext(), R.layout.spinner_textview,getResources().getStringArray(R.array.year));

        spinner_course.setAdapter(adapter_course);
        spinner_course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(mView.getContext(),spinner_course.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner_year.setAdapter(adapter_year);
        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(mView.getContext(),spinner_year.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),HomeActivity.class));
            }
        });
    }
}