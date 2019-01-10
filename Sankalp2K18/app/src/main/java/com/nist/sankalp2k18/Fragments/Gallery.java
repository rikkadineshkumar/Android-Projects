package com.nist.sankalp2k18.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialleanback.MaterialLeanBack;
import com.nist.sankalp2k18.R;

public class Gallery extends Fragment {


    MaterialLeanBack materialLeanBack;
    Pair<View, String> pair;
    View pair_view[]=new View[4];
    private View mView;
    private static int viewRow;

    int[] g_2016 = {R.drawable.g2016_1,R.drawable.g2016_2,R.drawable.g2016_3,R.drawable.g2016_4,R.drawable.g2016_5,
                    R.drawable.g2016_6,R.drawable.g2016_7,R.drawable.g2016_8,R.drawable.g2016_9,R.drawable.g2016_10};

    int[] g_2015 = {R.drawable.g2015_1,R.drawable.g2015_2,R.drawable.g2015_3,R.drawable.g2015_4,R.drawable.g2015_5,
            R.drawable.g2015_6,R.drawable.g2015_7,R.drawable.g2015_8,R.drawable.g2015_9,R.drawable.g2015_10};

    int[] g_2014 = {R.drawable.g2014_1,R.drawable.g2014_2,R.drawable.g2014_3,R.drawable.g2014_4,R.drawable.g2014_5,
            R.drawable.g2014_6,R.drawable.g2014_7,R.drawable.g2014_8,R.drawable.g2014_9,R.drawable.g2014_10};

    int[] g_2013 = {R.drawable.g2013_1,R.drawable.g2013_2,R.drawable.g2013_3,R.drawable.g2013_4,R.drawable.g2013_5,
            R.drawable.g2013_6,R.drawable.g2013_7,R.drawable.g2013_8,R.drawable.g2013_9,R.drawable.g2013_10};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.events,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView =view;
        materialLeanBack =(MaterialLeanBack) mView.findViewById(R.id.materialLeanBack);
        materialLeanBack.setAdapter(new MaterialLeanBack.Adapter<TestViewHolder>() {
            @Override
            public int getLineCount() {
                return 4;
            }

            @Override
            public int getCellsCount(int line) {
                viewRow=line;
                return 10;
            }

            @Override
            public TestViewHolder onCreateViewHolder(ViewGroup viewGroup, int line) {
                View viewHolder = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_layout, viewGroup, false);
                return new TestViewHolder(viewHolder);
            }

            @Override
            public void onBindViewHolder(TestViewHolder viewHolder, int i) {

                switch (viewRow){
                    case 0:
                        viewHolder.imageView.setBackgroundResource(g_2016[i]);
                        break;
                    case 1:
                        viewHolder.imageView.setBackgroundResource(g_2015[i]);
                        break;
                    case 2:
                        viewHolder.imageView.setBackgroundResource(g_2014[i]);
                        break;
                    case 3:
                        viewHolder.imageView.setBackgroundResource(g_2013[i]);
                        break;
                    default:
                        viewHolder.imageView.setBackgroundResource(g_2016[i]);
                }

                //viewHolder.textView.setText(game_name[i]);
                //String url = "http://www.lorempixel.com/40" + viewHolder.row + "/40" + viewHolder.cell + "/";
                //Picasso.with(viewHolder.imageView.getContext()).load(url).into(viewHolder.imageView);
                //viewHolder.imageView.setBackgroundResource(game[i]);
                //pair_view.add(i,viewHolder.imageView);
                //pair_view[i]=viewHolder.imageView;
            }

            @Override
            public String getTitleForRow(int row) {
                switch (row){
                    case 0:
                        return "SANKALP-2k16-17";
                    case 1:
                        return "SANKALP-2k15";
                    case 2:
                        return "SANKALP-2k14";
                    case 3:
                        return "SANKALP-2k13";
                    default:
                        return "";
                }
            }

        });

        materialLeanBack.setOnItemClickListener(new MaterialLeanBack.OnItemClickListener() {
            @Override
            public void onTitleClicked(int row, String text) {
                //Toast.makeText(mView.getContext(), "onTitleClicked " + row + " " + text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClicked(int row, int column) {
                //Toast.makeText(mView.getContext(), "onItemClicked " + row + " " + column, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
