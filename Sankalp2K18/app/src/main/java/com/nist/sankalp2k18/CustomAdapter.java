package com.nist.sankalp2k18;

/**
 * Created by ABHISHEK on 3/4/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] galleryImages;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] galleryImages) {
        this.context = applicationContext;
        this.galleryImages = galleryImages;
        inflter = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return galleryImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.flipper_items, null);
        ImageView galleryView = (ImageView) view.findViewById(R.id.imageView);
        galleryView.setImageResource(galleryImages[position]);
        return view;
    }
}