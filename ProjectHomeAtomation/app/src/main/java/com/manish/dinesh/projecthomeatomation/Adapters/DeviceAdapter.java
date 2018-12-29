package com.manish.dinesh.projecthomeatomation.Adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.manish.dinesh.projecthomeatomation.Models.Device;
import com.manish.dinesh.projecthomeatomation.R;
import com.manish.dinesh.projecthomeatomation.RestServices.HttpRequestArduinoControl;
import com.triggertrap.seekarc.SeekArc;


import java.util.List;

/**
 * Created by R Dinesh Kumar on 25-9-17.
 */

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceAdapterHolder> {

    private LayoutInflater inflater;
    List<Device> deviceList ;
    String uid;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public DeviceAdapter(Context context, List<Device> deviceList, String uid) {
        inflater = LayoutInflater.from(context);
        this.deviceList = deviceList;
        this.uid = uid;
    }

    @Override
    public DeviceAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout , parent, false);
        DeviceAdapterHolder holder =  new DeviceAdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final DeviceAdapterHolder holder, int position) {
        Device d = deviceList.get(position);
        int did = d.getDid();
        if(d.getDetails().equals("Ceiling Fan")){
            //holder.require_regulator=true;
            holder.regulatorcardlayout();
            DatabaseReference dbref1 = databaseReference.child("arduino").child(uid).child("devices").child(""+(did)).child("extraData");
            dbref1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try{holder.mSeekArc.setProgress(Integer.parseInt(dataSnapshot.getValue().toString()));}catch(Exception e){}
                    // Toast.makeText(, "", Toast.LENGTH_SHORT).show();
                    //holder.mSeekArc.setProgress(100);
                    holder.textView_seekArc_progress.setText(dataSnapshot.getValue().toString());
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
            //set seek arc as last progress
            try{holder.mSeekArc.setProgress(Integer.parseInt(d.getExtraData()));}catch(Exception e){}
        }else{
            holder.simplecardlayout();
        }
        holder.did = d.getDid();
        //holder.aid = ;
        //holder.imageView_device_pic.setBackgroundResource();
        holder.switch_device_name.setText(d.getName());
        holder.textView_power_usage.setText("Power usage  : "+d.getPowerCunsumption());
        holder.textView_total_power_consume.setText("Total Power Consumed: "+d.getTotalPowerConsumed());
        holder.imageView_device_pic.setImageResource(R.drawable.fluorescent_bulb);
        //set switch on or off
        if(d.getOnORoff())
            holder.switch_device_name.setChecked(true);
        else
            holder.switch_device_name.setChecked(false);
        //update switch state in real-time
        DatabaseReference dbref = databaseReference.child("arduino").child(uid).child("devices").child(""+(did)).child("onORoff");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue().equals(true)){
                    holder.switch_device_name.setChecked(true);
                    holder.imageView_device_pic.setImageResource(R.drawable.fluorescent_bulb);
                }else{
                    holder.switch_device_name.setChecked(false);
                    holder.imageView_device_pic.setImageResource(R.drawable.fluorescent_bulb_2);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public class DeviceAdapterHolder extends RecyclerView.ViewHolder{

        Switch switch_device_name;
        TextView textView_power_usage, textView_total_power_consume,textView_seekArc_progress;
        ImageView imageView_device_pic;
        ConstraintLayout constraintLayoutspinner,constraintLayoutRoot;
        SeekArc mSeekArc;
        //boolean require_regulator=false;

        public int did;
        public int aid;

        public DeviceAdapterHolder(final View itemView) {
            super(itemView);

            imageView_device_pic = itemView.findViewById(R.id.card_device_imageView);
            switch_device_name = itemView.findViewById(R.id.card_switch_with_device_name);
            textView_power_usage = itemView.findViewById(R.id.card_power_usage);
            textView_total_power_consume = itemView.findViewById(R.id.card_power_consumed);
            textView_seekArc_progress = itemView.findViewById(R.id.seekArk_count_txtview);
            mSeekArc = itemView.findViewById(R.id.bangThreshold);
            constraintLayoutspinner = itemView.findViewById(R.id.constraint_layout_seekarc);
            constraintLayoutRoot = itemView.findViewById(R.id.contraint_layout_card_root);

            /*mSeekArc.setArcRotation(100);
            mSeekArc.setStartAngle(1);
            mSeekArc.setSweepAngle(1);
            mSeekArc.setArcWidth(50);
            mSeekArc.setProgressWidth(1);
            mSeekArc.setRoundedEdges(true);
            mSeekArc.setTouchInSide(true);
            mSeekArc.setClockwise(true);
            mSeekArc.setEnabled(true);
            mSeekArc.invalidate();*/

            switch_device_name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){
                       /* HttpRequestArduinoControl httpRequestArduinoControl = new HttpRequestArduinoControl();
                        httpRequestArduinoControl.onORoff=1;
                        httpRequestArduinoControl.aid=aid;
                        httpRequestArduinoControl.did=did;
                        httpRequestArduinoControl.execute();
                        while (!httpRequestArduinoControl.request_status);*/
                        databaseReference.child("arduino").child(uid).child("devices").child(""+(did)).child("onORoff").setValue(true);
                        imageView_device_pic.setImageResource(R.drawable.fluorescent_bulb);
                    }else{
                        /*HttpRequestArduinoControl httpRequestArduinoControl = new HttpRequestArduinoControl();
                        httpRequestArduinoControl.onORoff=0;
                        httpRequestArduinoControl.aid=aid;
                        httpRequestArduinoControl.did=did;
                        httpRequestArduinoControl.execute();
                        while (!httpRequestArduinoControl.request_status);*/
                        databaseReference.child("arduino").child(uid).child("devices").child(""+(did)).child("onORoff").setValue(false);
                        imageView_device_pic.setImageResource(R.drawable.fluorescent_bulb_2);
                    }
                }
            });
        }

        public  void simplecardlayout(){
            constraintLayoutspinner.setMaxHeight(0);
            constraintLayoutspinner.setMaxWidth(0);
            constraintLayoutRoot.setMaxHeight(230);
        }

        public void regulatorcardlayout(){
             mSeekArc.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() {
                        @Override
                        public void onProgressChanged(SeekArc seekArc, int i, boolean b) {
                            textView_seekArc_progress.setText(""+i);
                        }

                        @Override
                        public void onStartTrackingTouch(SeekArc seekArc) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekArc seekArc) {
                            databaseReference.child("arduino").child(uid).child("devices").child(""+(did)).child("extraData").setValue(""+seekArc.getProgress());
                        }
             });
        }
    }
}