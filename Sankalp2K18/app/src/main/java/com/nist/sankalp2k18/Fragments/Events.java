package com.nist.sankalp2k18.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialleanback.MaterialLeanBack;
import com.nist.sankalp2k18.DetailsScrollingActivity;
import com.nist.sankalp2k18.R;

/**
 * Created by ABHISHEK on 2/18/2018.
 */

public class Events extends Fragment {

    MaterialLeanBack materialLeanBack;
    Pair<View, String> pair;
    View pair_view[]=new View[4];
    private View mView;
    private static int viewrow;

    String[] technical_name = {"INFINITY WAR","THE GREEN MILE","ZERO ERROR","OVERNIGHT CODING",
                                "REPOSITORY INSPECTION","FORT KNOX","PHOTO SHOP","DEBUGGERS PARADISE",
                                "PAPER PRESENTATION","THE DERELICT MARKET","SPAN IT","LAB VIEW",
                                "TEFITI'S HEART","ALL FOR NAUGHT","INFI-LINX","NAVCHAR ABHIKALPANA","SHOONYAE SARVOTTAM",
                                "TAME THE MUSTANG","AQUATRIX","MODEL PRESENTATION","SPICE-TO-INFINITY"};
    int[] technical_desc = {R.string.tiw,R.string.tgm,R.string.tze,R.string.toc,R.string.tri,R.string.tfk,R.string.tps,R.string.tdp,
            R.string.tpp,R.string.tdm,R.string.tsi,R.string.tlv,R.string.tth,R.string.tafn,R.string.til,R.string.tna,R.string.tss,
            R.string.tttm,R.string.ta,R.string.tmp,R.string.tsti,};
    int[] technical = {R.drawable.t_robo_war,R.drawable.t_robo_race,R.drawable.t_zero_error,R.drawable.t_overnight,
                        R.drawable.t_hardware,R.drawable.t_fknock,R.drawable.t_photo_shop,R.drawable.t_debuggers_paradise,
                        R.drawable.t_paper_presentation,R.drawable.t_direlect_market, R.drawable.t_span,R.drawable.t_labview,
                        R.drawable.t_quest,R.drawable.t_quiz,R.drawable.t_xilinx,R.drawable.t_navikarman, R.drawable.t_shoonya,
                        R.drawable.t_tame,R.drawable.t_aqua,R.drawable.t_civmod,R.drawable.t_pspice};


    String[] management_name = {"BULLS & BEARS","BUSINESS PAPER PRESENTATION","THE RADICLE","CHAKRAVYU","ANTHAPRENA SAGA","THE SENATOR","ODYSSEY ISTORIA"};
    int[] management_desc = {R.string.mbb,R.string.mbpp,R.string.mtr,R.string.mc,R.string.mas,R.string.mts,R.string.moi};
    int[] management = {R.drawable.m_bulls_and_bears,R.drawable.m_business_paper_presentation,R.drawable.m_devil,R.drawable.m_chakravyuh,
                        R.drawable.m_edc,R.drawable.m_integral,R.drawable.m_hunt};

    String[] fun_name = {"CLASH OF CLANS","VIRTUAL LABYRINTH","WALL CLIMBING","ZORBING","THE OAK ISLAND","TABOO QUIZ","RUSH HOUR","PIC-A-PIC"};
    int[] fun_desc = {R.string.fcoc,R.string.fvl,R.string.fwc,R.string.fz,R.string.foi,R.string.ftq,R.string.frh,R.string.fpp};
    int[] fun = {R.drawable.f_clash_of_clans,R.drawable.f_nth,R.drawable.f_wall_climbing,R.drawable.f_zorbing,R.drawable.f_treasure,
                R.drawable.f_taboo, R.drawable.f_rush,R.drawable.f_picapic};

    String[] game_name = {"COUNTER STRIKE","FIFA","NFS MOST-WANTED","NBA-2K14"};
    int[] game_desc = {R.string.gcs,R.string.gf,R.string.gnfs,R.string.ginb};
    int[] game = {R.drawable.g_counter_strike,R.drawable.g_fifa,R.drawable.g_nfs_mostwanted,R.drawable.g_nba_2k14};

    String[] workshop_name = {"ETHICAL HACKING","NIKON PHOTOGRAPHY","MIND-CONTROLLED ROBOTICS","TERRIBLY TINY TALES"};
    int[] workshop_desc = {R.string.weh,R.string.wnp,R.string.wmcr,R.string.wfw};
    int[] workshop = {R.drawable.w_ethical,R.drawable.w_nikon,R.drawable.w_mind_controlled_robotics,R.drawable.w_writing};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView =view;

        materialLeanBack =(MaterialLeanBack) mView.findViewById(R.id.materialLeanBack);
        materialLeanBack.setAdapter(new MaterialLeanBack.Adapter<TestViewHolder>() {
            @Override
            public int getLineCount() {
                return 5;
            }

            @Override
            public int getCellsCount(int line) {
                viewrow=line;
                switch (line){
                    case 0:
                        return technical_name.length;
                    case 1:
                        return management_name.length;
                    case 2:
                        return fun_name.length;
                    case 3:
                        return game_name.length;
                    case 4:
                        return workshop_name.length;
                    default:
                        return 0;
                }
            }

            @Override
            public TestViewHolder onCreateViewHolder(ViewGroup viewGroup, int line) {
                View viewHolder = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events_cell, viewGroup, false);
                return new TestViewHolder(viewHolder);
            }

            @Override
            public void onBindViewHolder(TestViewHolder viewHolder, int i) {

                switch (viewrow){
                    case 0:
                        viewHolder.textView.setText(technical_name[i]);
                        viewHolder.imageView.setBackgroundResource(technical[i]);
                        break;
                    case 1:
                        viewHolder.textView.setText(management_name[i]);
                        viewHolder.imageView.setBackgroundResource(management[i]);
                        break;
                    case 2:
                        viewHolder.textView.setText(fun_name[i]);
                        viewHolder.imageView.setBackgroundResource(fun[i]);
                        break;
                    case 3:
                        viewHolder.textView.setText(game_name[i]);
                        viewHolder.imageView.setBackgroundResource(game[i]);
                        break;
                    case 4:
                        viewHolder.textView.setText(workshop_name[i]);
                        viewHolder.imageView.setBackgroundResource(workshop[i]);
                        break;
                    default:
                        viewHolder.textView.setText(technical_name[i]);
                        viewHolder.imageView.setBackgroundResource(technical[i]);
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
                        return "TECHNICAL EVENTS";
                    case 1:
                        return "MANAGEMENT EVENTS";
                    case 2:
                        return "FUN & ADVENTURE EVENTS";
                    case 3:
                        return "GAMES";
                    case 4:
                        return "WORKSHOP";
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
                Intent intent=new Intent(mView.getContext(),DetailsScrollingActivity.class);
                switch (row){
                    case 0:
                        intent.putExtra("img",technical[column-1]);
                        intent.putExtra("txt",technical_name[column-1]);
                        intent.putExtra("desc",technical_desc[column-1]);
                        break;
                    case 1:
                        intent.putExtra("img",management[column-1]);
                        intent.putExtra("txt",management_name[column-1]);
                        intent.putExtra("desc",management_desc[column-1]);
                        break;
                    case 2:
                        intent.putExtra("img",fun[column-1]);
                        intent.putExtra("txt",fun_name[column-1]);
                        intent.putExtra("desc",fun_desc[column-1]);
                        break;
                    case 3:
                        intent.putExtra("img",game[column-1]);
                        intent.putExtra("txt",game_name[column-1]);
                        intent.putExtra("desc",game_desc[column-1]);
                        break;
                    case 4:
                        intent.putExtra("img",workshop[column-1]);
                        intent.putExtra("txt",workshop_name[column-1]);
                        intent.putExtra("desc",workshop_desc[column-1]);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //pair = Pair.create(pair_view[column-1], "image");
                    //Pair<View, String> pair1 = Pair.create(getc, "image");
                    //Pair<View, String> pair2 = Pair.create(textView, "title");
                    //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mView.getContext(), pair);
                    //startActivity(intent, options.toBundle());
                    //startActivity(intent);
                }
                else {
                    //startActivity(intent);
                }*/
            }
        });

    }
}
