package com.nist.sankalp2k18.Fragments;

import android.view.View;
import android.widget.TextView;

import com.github.florent37.materialleanback.MaterialLeanBack.ViewHolder;
import com.nist.sankalp2k18.R;

/**
 * Created by ABHISHEK on 2/21/2018.
 */

public class TestViewHolder extends ViewHolder {

    TextView textView;
    View imageView;

    public TestViewHolder (final View itemView){
        super(itemView);

        textView = (TextView) itemView.findViewById(R.id.textView);
        imageView = itemView.findViewById(R.id.imageView);
    }

}
