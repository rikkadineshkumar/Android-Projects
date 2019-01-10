package com.nist.sankalp2k18.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import com.nist.sankalp2k18.CustomAdapter;
import com.nist.sankalp2k18.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<ListItem> list;
    int cultural[]={R.drawable.c_art,R.drawable.c_cave,R.drawable.c_mr_sankalp,R.drawable.c_dance,R.drawable.c_andaz,R.drawable.c_meta,R.drawable.c_titans};
    String culturalName[]={"FLORA AND FAUNA","ECOSPOOKY CAVE","Mr. & Ms. SANKALP-2K18","INTER-COLLEGE DANCE","ANDAAZ NUKKAD KA","METAMORPHOSIS","VERDURES OF DIONYSUS"};

    private AdapterViewFlipper adapterViewFlipper;
    private int[] galleryImages = {R.drawable.g2015_1,R.drawable.g2013_2,R.drawable.g2013_4,R.drawable.g2015_4,R.drawable.g2013_3,R.drawable.g2016_6,
            R.drawable.g2016_10,R.drawable.g2014_6,R.drawable.g2013_8,R.drawable.g2014_9,R.drawable.g2015_9,R.drawable.g2016_2,R.drawable.g2016_3,
            R.drawable.g2016_4,R.drawable.g2016_5,R.drawable.g2016_9};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        //getting adapterviewflipper
        adapterViewFlipper = (AdapterViewFlipper) view.findViewById(R.id.adapterViewFlipper);
        // Custom Adapter for setting the data in Views
        CustomAdapter customAdapter = new CustomAdapter(view.getContext(), galleryImages);
        // set adapter for AdapterViewFlipper
        adapterViewFlipper.setAdapter(customAdapter);
        // set interval time for flipping between views
        adapterViewFlipper.setFlipInterval(1000);
        // set auto start for flipping between views
        adapterViewFlipper.setAutoStart(true);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));//2 indicate no of column
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));//vertical list
        //recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));//horizontal list
        //true (scroll from left to right)          false (scroll from right to left)
        list = new ArrayList<>();
        for (int i = 0; i < cultural.length; i++) {
            ListItem listitem = new ListItem(culturalName[i],cultural[i]);
            list.add(listitem);
        }
        adapter = new MyAdapter(list, view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
