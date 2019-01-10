package com.nist.sankalp2k18.Fragments;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nist.sankalp2k18.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> listItems;
    //int cultural[]={R.drawable.c_art,R.drawable.c_cave,R.drawable.c_mr_sankalp,R.drawable.c_dance,R.drawable.c_andaz,R.drawable.c_meta,R.drawable.c_titans};
    //String culturalName[]={"FLORA AND FAUNA","ECOSPOOKY CAVE","Mr. & Mrs. SANKALP-2K18","INTER-COLLEGE DANCE","ANDAAZ NUKKAD KA","METAMORPHOSIS","VERDURES OF DIONYSUS"};
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, final int position) {

        final ListItem listItem=listItems.get(position);
        holder.title.setText(listItem.getTitle());
        holder.imageView.setImageResource(listItem.getImageID());

        /*holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {        Picasso.with(context)
                    .load(listItem.getImageID())
                    //.load("https://media.mnn.com/assets/images/2015/03/forest-path-germany.jpg")
                    .into(holder.imageView);

                Toast.makeText(context,"U clicked "+holder.title.getText(),Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView imageView;
        public CardView linearLayout;
        public ViewHolder(View itemView) {

            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title_text);
            imageView=(ImageView)itemView.findViewById(R.id.thumb_img);
            linearLayout= (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
