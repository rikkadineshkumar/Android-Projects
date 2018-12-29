package com.nist.sankalp2k18.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nist.sankalp2k18.R;

/**
 * Created by ABHISHEK on 2/18/2018.
 */

public class OfficeBearers extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.about_sankalp,container,false);
        return view;
    }
}
